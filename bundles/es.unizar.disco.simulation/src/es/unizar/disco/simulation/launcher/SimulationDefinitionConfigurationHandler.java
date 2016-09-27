package es.unizar.disco.simulation.launcher;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

import es.unizar.disco.core.collections.Function;
import es.unizar.disco.core.collections.UnmodifiableTransformedMap;
import es.unizar.disco.core.logger.DiceLogger;
import es.unizar.disco.simulation.DiceSimulationPlugin;
import es.unizar.disco.simulation.models.datatypes.ComputableNFPtype;
import es.unizar.disco.simulation.models.datatypes.DatatypesFactory;
import es.unizar.disco.simulation.models.definition.DefinitionFactory;
import es.unizar.disco.simulation.models.definition.InputVariable;
import es.unizar.disco.simulation.models.definition.InputVariableValue;
import es.unizar.disco.simulation.models.definition.OutputVariable;
import es.unizar.disco.simulation.models.definition.SimulationDefinition;
import es.unizar.disco.simulation.models.definition.VariableConfiguration;
import es.unizar.disco.simulation.models.measures.DomainMeasureDefinition;

public final class SimulationDefinitionConfigurationHandler {

	public static final String SIMULATION_DEFINITION__DOMAIN_RESOURCE_URI = "SIMULATION_DEFINITION__DOMAIN_RESOURCE_URI"; //$NON-NLS-1$

	public static final String SIMULATION_DEFINITION__ACTIVE_SCENARIO = "SIMULATION_DEFINITION__ACTIVE_SCENARIO"; //$NON-NLS-1$

	public static final String SIMULATION_DEFINITION__INPUT_VARIABLES = "SIMULATION_DEFINITION__INPUT_VARIABLES"; //$NON-NLS-1$

	public static final String SIMULATION_DEFINITION__OUTPUT_VARIABLES = "SIMULATION_DEFINITION__OUTPUT_VARIABLES"; //$NON-NLS-1$

	public static final String SIMULATION_DEFINITION__MAX_EXECUTION_TIME = "SIMULATION_DEFINITION__MAX_EXECUTION_TIME"; //$NON-NLS-1$

	public static final String SIMULATION_DEFINITION__PARAMETERS = "SIMULATION_DEFINITION__PARAMETERS"; //$NON-NLS-1$

	public static final String SIMULATION_DEFINITION__MEASURES_TO_COMPUTE = "SIMULATION_DEFINITION__MEASURES_TO_COMPUTE"; //$NON-NLS-1$

	public static final String SIMULATION_DEFINITION__BACKEND = "SIMULATION_DEFINITION__BACKEND"; //$NON-NLS-1$

	public static final String SIMULATION_DEFINITION__ACTIVE_CONFIGURATIONS = "SIMULATION_DEFINITION__ACTIVE_CONFIGURATIONS"; //$NON-NLS-1$

	public static final String SIMULATION_DEFINITION__NFP_TO_COMPUTE = "SIMULATION_DEFINITION__NFP_TO_COMPUTE";
	private final SimulationDefinition definition;

	private SimulationDefinitionConfigurationHandler(SimulationDefinition definition) {
		this.definition = definition;
		if (definition.getDomainResource() == null) {
			definition.setDomainResource(DatatypesFactory.eINSTANCE.createResource());
		}
	}

	public static SimulationDefinitionConfigurationHandler create(SimulationDefinition definition) {
		return new SimulationDefinitionConfigurationHandler(definition);
	}

	public void initializeResourceUri(ILaunchConfiguration configuration) throws CoreException {
		URI domainResourceUri = URI
				.createURI(configuration.getAttribute(SIMULATION_DEFINITION__DOMAIN_RESOURCE_URI, ""));
		if (!domainResourceUri.equals(definition.getDomainResource().getUri())) {
			definition.getDomainResource().setUri(domainResourceUri);
		}
	}

	public void saveResourceUri(ILaunchConfigurationWorkingCopy configuration) {
		String domainResourceUri = defaultToString(definition.getDomainResource().getUri());
		configuration.setAttribute(SIMULATION_DEFINITION__DOMAIN_RESOURCE_URI, domainResourceUri);
	}

	public void initializeInputVariables(ILaunchConfiguration configuration) throws CoreException {
		Map<String, String> inputVarsInfo = configuration.getAttribute(SIMULATION_DEFINITION__INPUT_VARIABLES,
				new HashMap<String, String>());
		for (Entry<String, String> entry : inputVarsInfo.entrySet()) {
			String varName = entry.getKey();
			if (definition.getInputVariablesMap().get(varName) == null) {
				InputVariable var = DefinitionFactory.eINSTANCE.createInputVariable();
				var.setName(varName);
				var.deserializeValues(entry.getValue());
				definition.getInputVariables().add(var);
			}
		}
	}

	public void saveInputVariables(ILaunchConfigurationWorkingCopy configuration) {
		Map<String, String> inputVarsInfo = new UnmodifiableTransformedMap<String, InputVariable, String>(
				definition.getInputVariablesMap(), new InputVariableToSerializedValues());
		configuration.setAttribute(SIMULATION_DEFINITION__INPUT_VARIABLES, inputVarsInfo);

	}

	public void initializeOutputVariables(ILaunchConfiguration configuration) throws CoreException {
		Map<String, String> outputVarsInfo = configuration.getAttribute(SIMULATION_DEFINITION__OUTPUT_VARIABLES,
				new HashMap<String, String>());
		for (Entry<String, String> entry : outputVarsInfo.entrySet()) {
			String varName = entry.getKey();
			if (definition.getOutputVariablesMap().get(varName) == null) {
				OutputVariable var = DefinitionFactory.eINSTANCE.createOutputVariable();
				var.setName(varName);
				definition.getOutputVariables().add(var);
			}
		}
	}

	public void saveOutputVariables(ILaunchConfigurationWorkingCopy configuration) {
		Map<String, String> outputVarsInfo = new UnmodifiableTransformedMap<String, OutputVariable, String>(
				definition.getOutputVariablesMap(), new OutputVariableToEmptyString());
		configuration.setAttribute(SIMULATION_DEFINITION__OUTPUT_VARIABLES, outputVarsInfo);

	}

	public void initializeActiveScenario(ILaunchConfiguration configuration) throws CoreException {
		URI activeScenarioUri = URI.createURI(configuration.getAttribute(SIMULATION_DEFINITION__ACTIVE_SCENARIO, ""));
		if (definition.getActiveScenario() == null
				|| EcoreUtil.getURI(definition.getActiveScenario()).equals(activeScenarioUri)) {
			for (EObject scenario : definition.getScenarios()) {
				if (EcoreUtil.getURI(scenario).equals(activeScenarioUri)) {
					definition.setActiveScenario(scenario);
				}
			}
		}
	}

	public void saveActiveScenario(ILaunchConfigurationWorkingCopy configuration) {
		String activeScenarioUri = defaultToString(
				definition.getActiveScenario() != null ? EcoreUtil.getURI(definition.getActiveScenario()) : null);
		configuration.setAttribute(SIMULATION_DEFINITION__ACTIVE_SCENARIO, activeScenarioUri);

	}

	public void initializeSelectedMeasures(ILaunchConfiguration configuration) throws CoreException {
		Set<String> selectedMeasures = configuration.getAttribute(SIMULATION_DEFINITION__MEASURES_TO_COMPUTE,
				(Set<String>) null);
		if (selectedMeasures != null) {
			for (DomainMeasureDefinition domainMeasure : definition.getDeclaredMeasures()) {
				if (selectedMeasures.contains(EcoreUtil.getURI(domainMeasure).toString())) {
					definition.getMeasuresToCompute().add(domainMeasure);
				} else {
					definition.getMeasuresToCompute().remove(domainMeasure);
				}
			}
		}
	}

	public void saveSelectedMeasures(ILaunchConfigurationWorkingCopy configuration) {
		if (definition.getDeclaredMeasures().size() != definition.getMeasuresToCompute().size()) {
			Set<String> selectedMeasures = new HashSet<>();
			for (DomainMeasureDefinition measureDefinition : definition.getMeasuresToCompute()) {
				selectedMeasures.add(EcoreUtil.getURI(measureDefinition).toString());
			}
			configuration.setAttribute(SIMULATION_DEFINITION__MEASURES_TO_COMPUTE, selectedMeasures);
		} else {
			configuration.removeAttribute(SIMULATION_DEFINITION__MEASURES_TO_COMPUTE);
		}
	}

	public void initializeActiveConfigurations(ILaunchConfiguration configuration) throws CoreException {
		Set<String> activeConfigurations = configuration.getAttribute(SIMULATION_DEFINITION__ACTIVE_CONFIGURATIONS,
				(Set<String>) null);
		if (activeConfigurations != null) {
			for (VariableConfiguration possibleConfiguration : definition.getPossibleConfigurations()) {
				if (activeConfigurations.contains(EcoreUtil.getURI(possibleConfiguration).toString())) {
					definition.getActiveConfigurations().add(possibleConfiguration);
				} else {
					definition.getActiveConfigurations().remove(possibleConfiguration);
				}
			}
		} else {
			// We must select them manually since the data binding
			// mechanisms mechanisms interfere with the
			// syncPossibleVariableConfigurations method from
			// SimulationDefinition
			definition.getActiveConfigurations().addAll(definition.getPossibleConfigurations());
		}
	}

	public void saveActiveConfigurations(ILaunchConfigurationWorkingCopy configuration) {
		// The same applies for the active configurations
		if (definition.getPossibleConfigurations().size() != definition.getActiveConfigurations().size()) {
			Set<String> activeConfigurations = new HashSet<>();
			for (VariableConfiguration activeConfiguration : definition.getActiveConfigurations()) {
				activeConfigurations.add(EcoreUtil.getURI(activeConfiguration).toString());
			}
			configuration.setAttribute(SIMULATION_DEFINITION__ACTIVE_CONFIGURATIONS, activeConfigurations);
		} else {
			configuration.removeAttribute(SIMULATION_DEFINITION__ACTIVE_CONFIGURATIONS);
		}
	}

	public void initializeParameters(ILaunchConfiguration configuration) throws CoreException {
		Map<String, String> parameters = configuration.getAttribute(SIMULATION_DEFINITION__PARAMETERS,
				new HashMap<String, String>());
		for (Entry<String, String> entry : parameters.entrySet()) {
			if (!StringUtils.equals(entry.getValue(), definition.getParameters().get(entry.getKey()))) {
				definition.getParameters().put(entry.getKey(), entry.getValue());
			}
		}
	}

	public void saveParameters(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(SIMULATION_DEFINITION__PARAMETERS, definition.getParameters().map());
	}

	public void initializeMaxExecutionTime(ILaunchConfiguration configuration) throws CoreException {
		Date maxExecTime = (Date) EcoreUtil.createFromString(EcorePackage.Literals.EDATE,
				configuration.getAttribute(SIMULATION_DEFINITION__MAX_EXECUTION_TIME, (String) null));
		if (maxExecTime != null && !maxExecTime.equals(definition.getMaxExecutionTime())) {
			definition.setMaxExecutionTime(maxExecTime);
		}
	}

	public void saveMaxExecutionTime(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(SIMULATION_DEFINITION__MAX_EXECUTION_TIME,
				EcoreUtil.convertToString(EcorePackage.Literals.EDATE, definition.getMaxExecutionTime()));
	}

	public void initializeNFPtoCompute(ILaunchConfiguration configuration) throws CoreException {
		DiceLogger.logInfo(DiceSimulationPlugin.getDefault(),
				"looking for value of attribute called " + SIMULATION_DEFINITION__NFP_TO_COMPUTE + " with value "
						+ configuration.getAttribute(SIMULATION_DEFINITION__NFP_TO_COMPUTE,
								ComputableNFPtype.PERFORMANCE.toString()));

		ComputableNFPtype nfpToCompute = ComputableNFPtype.get(configuration
				.getAttribute(SIMULATION_DEFINITION__NFP_TO_COMPUTE, ComputableNFPtype.PERFORMANCE.toString()));

		definition.setNfpToCompute(nfpToCompute);

	}

	public void saveNFPtoCompute(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(SIMULATION_DEFINITION__NFP_TO_COMPUTE, definition.getNfpToCompute().toString());

	}

	public void initializeBackend(ILaunchConfiguration configuration, String defaultValue) throws CoreException {
		String savedBackend = configuration.getAttribute(SIMULATION_DEFINITION__BACKEND, defaultValue);
		if (!StringUtils.equals(savedBackend, definition.getBackend())) {
			definition.setBackend(savedBackend);
		}

	}

	public void saveBackend(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(SIMULATION_DEFINITION__BACKEND, definition.getBackend());
	}

	protected static String defaultToString(Object obj) {
		return obj != null ? StringUtils.defaultString(obj.toString()) : "";
	}

	/**
	 * {@link Function} which transforms an {@link InputVariable} to a
	 * {@link String} containing its serialized {@link InputVariableValue}s
	 * 
	 * @author agomez
	 *
	 */
	private final class InputVariableToSerializedValues implements Function<InputVariable, String> {
		@Override
		public String apply(InputVariable obj) {
			return obj != null ? obj.serializeValues() : "";
		}
	}

	/**
	 * {@link Function} which always returns an empty String ("") value
	 * 
	 * @author agomez
	 *
	 */
	private final class OutputVariableToEmptyString implements Function<OutputVariable, String> {
		@Override
		public String apply(OutputVariable obj) {
			return "";
		}
	}

}
