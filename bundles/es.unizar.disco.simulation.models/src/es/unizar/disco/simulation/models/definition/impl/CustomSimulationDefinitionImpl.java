package es.unizar.disco.simulation.models.definition.impl;

import static org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage.Literals.GA_ANALYSIS_CONTEXT;
import static org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage.Literals.GA_ANALYSIS_CONTEXT__CONTEXT;
import static org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage.Literals.RESOURCE_USAGE__USED_RESOURCES;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections4.MultiMapUtils;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.collection.CompositeCollection;
import org.apache.commons.collections4.collection.CompositeCollection.CollectionMutator;
import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.DelegatingEcoreEList;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.EqualityHelper;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.google.common.collect.Lists;

import es.unizar.disco.core.collections.DerivedMap;
import es.unizar.disco.core.collections.Function;
import es.unizar.disco.simulation.models.datatypes.DatatypesPackage;
import es.unizar.disco.simulation.models.definition.DefinitionFactory;
import es.unizar.disco.simulation.models.definition.DefinitionPackage;
import es.unizar.disco.simulation.models.definition.InputVariable;
import es.unizar.disco.simulation.models.definition.InputVariableValue;
import es.unizar.disco.simulation.models.definition.OutputVariable;
import es.unizar.disco.simulation.models.definition.SimulationDefinition;
import es.unizar.disco.simulation.models.definition.Variable;
import es.unizar.disco.simulation.models.definition.VariableAssignment;
import es.unizar.disco.simulation.models.definition.VariableConfiguration;
import es.unizar.disco.simulation.models.invocation.InvocationFactory;
import es.unizar.disco.simulation.models.invocation.SimulationInvocation;
import es.unizar.disco.simulation.models.measures.DomainMeasureDefinition;
import es.unizar.disco.simulation.models.measures.MeasuresFactory;
import es.unizar.disco.simulation.models.util.DiceMetricsUtils;
import es.unizar.disco.simulation.models.util.DiceStereotypesUtils;
import es.unizar.disco.simulation.models.util.MarteStereotypesUtils;

public class CustomSimulationDefinitionImpl extends SimulationDefinitionImpl {

	private static final String GA_ANALYSIS_CONTEXT_QN = MarteStereotypesUtils.getStereotypeQn(GA_ANALYSIS_CONTEXT);

	/**
	 * {@link CompositeCollection} that aggregates both
	 * {@link #getInputVariables()} and {@link #getOutputVariables()}.
	 * Modifications in the {@link CompositeCollection} are reflected in the
	 * underlying collections
	 */
	private Collection<Variable> variables;

	/**
	 * {@link Map} view, indexed by {@link Variable#getName()}, of the
	 * <code>variables</code> property, which is an aggregation of
	 * {@link #getInputVariables()} and {@link #getOutputVariables()}
	 */
	private Map<String, Variable> variablesMap;

	/**
	 * {@link Map} view, indexed by {@link Variable#getName()}, of the
	 * <code>inputVariables</code> {@link EStructuralFeature}
	 */
	private Map<String, InputVariable> inputVariablesMap;

	/**
	 * {@link Map} view, indexed by {@link Variable#getName()}, of the
	 * <code>outputVariables</code> {@link EStructuralFeature}
	 */
	private Map<String, OutputVariable> outputVariablesMap;

	/**
	 * Adapter that will be attached to the domain
	 * {@link es.unizar.disco.simulation.models.datatypes.Resource} in order to
	 * synchronize the Scenarios when its {@link URI} changes
	 */
	private AdapterImpl resourceUriAdapter = new AdapterImpl() {
		@Override
		public void notifyChanged(Notification msg) {
			if (isAutoSync() && msg.getFeature() == DatatypesPackage.Literals.RESOURCE__URI) {
				syncScenarios();
			}
		}
	};

	/**
	 * {@link EContentAdapter} that will be attached to this
	 * {@link SimulationDefinition} to keep the
	 * {@link #getPossibleConfigurations()} in sync with the
	 * {@link #getInputVariables()} information
	 */
	private EContentAdapter variablesAdapter = new EContentAdapter() {
		@Override
		public void notifyChanged(final Notification notification) {
			super.notifyChanged(notification);
			if (isAutoSync() && (notification.getFeature() == DefinitionPackage.Literals.SIMULATION_DEFINITION__INPUT_VARIABLES
					|| notification.getFeature() == DefinitionPackage.Literals.INPUT_VARIABLE__VALUES)) {
				switch (notification.getEventType()) {
					case Notification.ADD:
					case Notification.REMOVE:
					case Notification.ADD_MANY:
					case Notification.REMOVE_MANY:
						syncPossibleVariableConfigurations();
						break;
					default:
						break;
				}
			}
		}
	};

	public CustomSimulationDefinitionImpl() {
		super();
		this.eAdapters().add(variablesAdapter);
	}

	@Override
	public String getIdentifier() {
		if (identifier == null) {
			identifier = UUID.randomUUID().toString();
		}
		return identifier;
	}

	@Override
	public EList<SimulationInvocation> getInvocations() {
		if (isAutoSync()) {
			List<VariableConfiguration> configurations = new ArrayList<>();
			configurations.addAll(getActiveConfigurations());
			// Do some cleanup...
			for (Iterator<SimulationInvocation> it = super.getInvocations().iterator(); it.hasNext();) {
				SimulationInvocation invocation = it.next();
				// If the invocation points to an outdated configuration, delete it
				if (!configurations.contains(invocation.getVariableConfiguration())) {
					it.remove();
				} else {
					// Else, the invocation points to an active configuration, and
					// should no be re-added
					configurations.remove(invocation.getVariableConfiguration());
				}
			}
			// Create new invocations
			for (VariableConfiguration configuration : configurations) {
				SimulationInvocation invocation = InvocationFactory.eINSTANCE.createSimulationInvocation();
				invocation.setVariableConfiguration(configuration);
				super.getInvocations().add(invocation);
			}
		}
		return super.getInvocations();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Variable> getVariables() {
		if (variables == null) {
			CompositeCollection<Variable> compositeCollection = new CompositeCollection<Variable>();
			compositeCollection.setMutator(new CompositeVariablesCollectionMutator());
			compositeCollection.addComposited((EList<Variable>) (Object) getInputVariables());
			compositeCollection.addComposited((EList<Variable>) (Object) getOutputVariables());
			variables = compositeCollection;
		}

		return variables;
	}

	@Override
	public EList<DomainMeasureDefinition> getDeclaredMeasures() {
		return new DelegatingEcoreEList.UnmodifiableEList<DomainMeasureDefinition>(this, DefinitionPackage.Literals.SIMULATION_DEFINITION__DECLARED_MEASURES,
				super.getDeclaredMeasures());
	}

	@Override
	public EList<VariableConfiguration> getPossibleConfigurations() {
		return new DelegatingEcoreEList.UnmodifiableEList<VariableConfiguration>(this,
				DefinitionPackage.Literals.SIMULATION_DEFINITION__POSSIBLE_CONFIGURATIONS, super.getPossibleConfigurations());
	}

	@Override
	public Map<String, Variable> getVariablesMap() {
		if (variablesMap == null) {
			variablesMap = new DerivedMap<String, Variable>(getVariables(), new VarToKeyFunction<Variable>());
		}
		return variablesMap;
	}

	@Override
	public Map<String, InputVariable> getInputVariablesMap() {
		if (inputVariablesMap == null) {
			inputVariablesMap = new DerivedMap<String, InputVariable>(getInputVariables(), new VarToKeyFunction<InputVariable>());
		}
		return inputVariablesMap;
	}

	@Override
	public Map<String, OutputVariable> getOutputVariablesMap() {
		if (outputVariablesMap == null) {
			outputVariablesMap = new DerivedMap<String, OutputVariable>(getOutputVariables(), new VarToKeyFunction<OutputVariable>());
		}
		return outputVariablesMap;
	}

	@Override
	public void setDomainResource(es.unizar.disco.simulation.models.datatypes.Resource newDomainResource) {
		es.unizar.disco.simulation.models.datatypes.Resource oldDomainResource = super.getDomainResource();
		if (newDomainResource != oldDomainResource) {
			if (oldDomainResource != null) {
				oldDomainResource.eAdapters().remove(resourceUriAdapter);
			}
			super.setDomainResource(newDomainResource);
			if (newDomainResource != null) {
				newDomainResource.eAdapters().add(resourceUriAdapter);
			}
		}
	};

	@Override
	public void setActiveScenario(EObject newActiveScenario) {
		EObject oldActiveScenario = super.getActiveScenario();
		super.setActiveScenario(newActiveScenario);
		if (newActiveScenario instanceof Element) {
			// Save which of the supported scenarios has the newActiveScenario applied
			Element element = (Element) newActiveScenario;
			for (String scenarioName : DiceStereotypesUtils.getScenariosStereotypes()) {
				Stereotype scenarioStereotype = element.getAppliedStereotype(scenarioName);
				if (element.isStereotypeApplied(scenarioStereotype)) {
					getScenarioStereotypes().add(scenarioName);
				}
			}
		}
		if (isAutoSync() && (newActiveScenario == null || newActiveScenario != oldActiveScenario)) {
			syncVariables();
			syncDomainMeasureDefinitions();
		}
	}

	@Override
	public void syncScenarios() {
		
		// Keep old data to restore it if necessary
		EObject oldActiveScenario = super.getActiveScenario();

		// Reset current information about scenarios
		setActiveScenario(null);
		getScenarios().clear();

		// Get the domain resource, which contains the scenarios' information
		if (getDomainResource() == null) {
			return;
		}
		Resource resource = getDomainResource().getResource();
		if (resource == null) {
			return;
		}

		// Rebuild the scenarios' information from the domain resource
		EList<EObject> scenarios = new BasicEList<>();
		for (Iterator<EObject> it = resource.getAllContents(); it.hasNext();) {
			EObject eObject = it.next();
			if (eObject instanceof Element) {
				Element element = (Element) eObject;
				for (String scenarioName : DiceStereotypesUtils.getScenariosStereotypes()) {
					Stereotype scenarioStereotype = element.getAppliedStereotype(scenarioName);
					if (element.isStereotypeApplied(scenarioStereotype)) {
						scenarios.add(eObject);
					}
				}
			}
		}

		// Update the information about the scenarios in the internal data
		// structures
		getScenarios().addAll(scenarios);
		if (getScenarios().contains(oldActiveScenario)) {
			setActiveScenario(oldActiveScenario);
		}
	}

	@Override
	public void syncVariables() {

		EObject scenarioEObject = getActiveScenario();

		if (scenarioEObject instanceof Element) {
			Element scenario = (Element) scenarioEObject;
			Stereotype gaAnalysisContextStereotype = scenario.getAppliedStereotype(GA_ANALYSIS_CONTEXT_QN);
			if (scenario.isStereotypeApplied(gaAnalysisContextStereotype)) {
				@SuppressWarnings("unchecked")
				List<String> context = (List<String>) scenario.getValue(gaAnalysisContextStereotype, GA_ANALYSIS_CONTEXT__CONTEXT.getName());

				// We do these operations separately for in and out vars just in
				// case a var with the same name has been changed from input to
				// output or vice versa

				// Collect new vars
				// Provide a Map-based view
				Set<Variable> parsedVars = parseVariables(context);
				Map<String, Variable> inParsedVars = new HashMap<String, Variable>();
				Map<String, Variable> outParsedVars = new HashMap<String, Variable>();
				for (Variable var : parsedVars) {
					if (var instanceof InputVariable) {
						inParsedVars.put(var.getName(), var);
					} else if (var instanceof OutputVariable) {
						outParsedVars.put(var.getName(), var);
					}
				}

				Map<String, InputVariable> oldInVarsMap = getInputVariablesMap();
				Map<String, OutputVariable> oldOutVarsMap = getOutputVariablesMap();

				// Delete variables the model no longer declares
				oldInVarsMap.keySet().retainAll(inParsedVars.keySet());
				oldOutVarsMap.keySet().retainAll(outParsedVars.keySet());
				// Remove new vars that have been already configured
				inParsedVars.keySet().removeAll(oldInVarsMap.keySet());
				outParsedVars.keySet().removeAll(oldOutVarsMap.keySet());
				// Add remaining new vars
				getVariablesMap().putAll(inParsedVars);
				getVariablesMap().putAll(outParsedVars);
			}
		} else {
			getVariables().clear();
		}
	}

	/**
	 * Parses the variables' information from <code>context</code>. In the case
	 * of the context having duplicated variables, only the first occurrence is
	 * considered
	 * 
	 * @param context
	 *            an {@link String} containing an the context of the scenario as
	 *            specified by the MARTE standard
	 * @return a {@link Set} of {@link Variable}s
	 */
	private Set<Variable> parseVariables(List<String> context) {
		Set<Variable> variables = new HashSet<>();
		Pattern pattern = Pattern.compile("(?<direction>in|out|inout)?\\s*\\$(?<name>\\w+)(\\s*:\\s*(?<type>\\w+))?(\\s*=\\s*(?<value>.+))?");
		for (String str : context) {
			Matcher matcher = pattern.matcher(str.trim());
			if (matcher.matches()) {
				String direction = matcher.group("direction");
				String name = matcher.group("name");
				// String type = matcher.group("type"); //Type is ignored
				String value = matcher.group("value");

				Variable variable;
				if ("out".equals(direction)) {
					variable = DefinitionFactoryImpl.eINSTANCE.createOutputVariable();
				} else {
					variable = DefinitionFactoryImpl.eINSTANCE.createInputVariable();
					if (value != null) {
						InputVariableValue variableValue = DefinitionFactory.eINSTANCE.createInputVariableValue();
						variableValue.setValue((Number) EcoreUtil.createFromString(DatatypesPackage.Literals.NUMBER, value));
						((InputVariable) variable).getValues().add(variableValue);
					}
				}
				variable.setName(name);
				variables.add(variable);

			}
		}
		return variables;
	}

	@Override
	public void syncDomainMeasureDefinitions() {

		EObject scenarioEObject = getActiveScenario();

		if (scenarioEObject instanceof Element) {
			Element scenario = (Element) scenarioEObject;

			// Build a map with the supported metrics stereotypes and tagged
			// values
			MultiValuedMap<String, String> metricsMap = MultiMapUtils.newSetValuedHashMap();
			for (DiceMetricsUtils.Metric metric : DiceMetricsUtils.getSupportedMetrics()) {
				metricsMap.put(metric.stereotype, metric.tag);
			}

			// Collect all interesting elements, we use an auxiliary list to
			// aggregate the activeScenario with the allOwnedElements
			List<Element> elements = new ArrayList<>();

			// Include the active scenario object
			elements.add(scenario);

			// Include all owned elements
			elements.addAll(scenario.allOwnedElements());

			// Include referenced resources
			for (String scenarioName : DiceStereotypesUtils.getScenariosStereotypes()) {
				Stereotype scenarioStereotype = scenario.getAppliedStereotype(scenarioName);
				if (scenario.isStereotypeApplied(scenarioStereotype)) {
					Object value = scenario.getValue(scenarioStereotype, RESOURCE_USAGE__USED_RESOURCES.getName());
					if (value != null) {
						@SuppressWarnings("unchecked")
						List<org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource> resources = (List<org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource>) value;
						for (org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource resource : resources) {
							elements.add(resource.getBase_Classifier());
						}
					}
				}
			}

			// Iterate looking for elements stereotyped with any supported
			// metric, and collect them
			List<DomainMeasureDefinition> newDefinitions = new ArrayList<>();
			for (Element element : elements) {
				for (Entry<String, Collection<String>> stereotypeEntry : metricsMap.asMap().entrySet()) {
					for (String taggedValueName : stereotypeEntry.getValue()) {
						Object value = UMLUtil.getTaggedValue(element, stereotypeEntry.getKey(), taggedValueName);
						if (value == null) {
							continue;
						}
						if (value instanceof EList<?>) {
							for (Object obj : (EList<?>) value) {
								if (obj instanceof String && StringUtils.isNotBlank((String) obj)) {
									newDefinitions.add(createDomainMeasureDefinition(element, taggedValueName, (String) obj));
								}
							}
						} else if (value instanceof String && StringUtils.isNotBlank((String) value)) {
							newDefinitions.add(createDomainMeasureDefinition(element, taggedValueName, (String) value));
						} else {
							// Unknown value, do nothing
						}
					}
				}
			}

			// Check if all the previous definitions were selected
			boolean allSelected = getDeclaredMeasures().size() == getMeasuresToCompute().size();

			EqualityHelper eqHelper = new EqualityHelper();

			// Discard already existing definitions
			for (Iterator<DomainMeasureDefinition> it = newDefinitions.iterator(); it.hasNext();) {
				DomainMeasureDefinition newDefinition = it.next();
				for (DomainMeasureDefinition oldDefinition : getDeclaredMeasures()) {
					if (eqHelper.equals(oldDefinition, newDefinition)) {
						it.remove();
						continue;
					}
				}
			}

			// Clean outdated definitions
			for (Iterator<DomainMeasureDefinition> it = super.getDeclaredMeasures().iterator(); it.hasNext();) {
				DomainMeasureDefinition oldDefinition = it.next();
				boolean found = false;
				for (DomainMeasureDefinition newDefinition : newDefinitions) {
					if (eqHelper.equals(oldDefinition, newDefinition)) {
						found = true;
						continue;
					}
					if (!found) {
						it.remove();
						getMeasuresToCompute().remove(oldDefinition);
					}
				}
			}

			// Add new remaining measures
			super.getDeclaredMeasures().addAll(newDefinitions);

			// If all the previous definitions were selected, select the new
			// ones too
			if (allSelected) {
				getMeasuresToCompute().addAll(newDefinitions);
			}
		} else {
			super.getDeclaredMeasures().clear();
			getMeasuresToCompute().clear();
		}
	}

	private DomainMeasureDefinition createDomainMeasureDefinition(Element element, String taggedValueName, String expression) {
		DomainMeasureDefinition measureDefinition = MeasuresFactory.eINSTANCE.createDomainMeasureDefinition();
		measureDefinition.setMeasuredElement(element);
		measureDefinition.setMeasure(taggedValueName);
		measureDefinition.setVslExpression(expression);
		return measureDefinition;
	}

	@Override
	public void syncPossibleVariableConfigurations() {

		if (!canCreateConfigs()) {
			if (possibleConfigurations != null && !possibleConfigurations.isEmpty()) {
				possibleConfigurations.clear();
				getActiveConfigurations().clear();
			}
			return;
		}

		// Check if all the previous configurations were selected
		boolean allSelected = getPossibleConfigurations().size() == getActiveConfigurations().size();

		List<List<InputVariableValue>> allValues = new ArrayList<>();
		for (InputVariable inVariable : getInputVariables()) {
			allValues.add(new ArrayList<>(inVariable.getValues()));
		}

		List<List<InputVariableValue>> combinations = Lists.cartesianProduct(allValues);
		// Build possible configurations
		List<VariableConfiguration> configurations = new BasicEList<VariableConfiguration>();
		for (List<InputVariableValue> list : combinations) {
			VariableConfiguration configuration = DefinitionFactory.eINSTANCE.createVariableConfiguration();
			for (InputVariableValue varValue : list) {
				VariableAssignment assignment = DefinitionFactory.eINSTANCE.createVariableAssignment();
				assignment.setVariable(varValue.getVariable());
				assignment.setValue(varValue);
				configuration.getAssignments().add(assignment);
			}
			configurations.add(configuration);
		}

		// Cleanup outdated configurations
		Set<VariableAssignment> assignmentsToRemove = new HashSet<>();
		for (Iterator<VariableConfiguration> itOld = super.getPossibleConfigurations().iterator(); itOld.hasNext();) {
			VariableConfiguration oldConfig = itOld.next();
			boolean found = false;
			for (Iterator<VariableConfiguration> itNew = configurations.iterator(); itNew.hasNext();) {
				VariableConfiguration newConfig = itNew.next();
				if (newConfig.isEquivalent(oldConfig)) {
					for (VariableAssignment assignment : newConfig.getAssignments()) {
						assignment.getVariable().getAssignments().remove(assignment);
						assignment.getValue().getAssignments().remove(assignment);
					}
					itNew.remove();
					assignmentsToRemove.addAll(newConfig.getAssignments());
					found = true;
					break;
				}
			}
			if (!found) {
				for (VariableAssignment assignment : oldConfig.getAssignments()) {
					assignment.getVariable().getAssignments().remove(assignment);
					assignment.getValue().getAssignments().remove(assignment);
				}
				itOld.remove();
				assignmentsToRemove.addAll(oldConfig.getAssignments());
				getActiveConfigurations().remove(oldConfig);
			}
		}

		// Add new configurations
		for (VariableConfiguration newConfig : configurations) {
			super.getPossibleConfigurations().add(newConfig);
			if (allSelected) {
				// If all the previous Configurations were selected, select
				// the new one too
				getActiveConfigurations().add(newConfig);
			}
		}
	}

	private boolean canCreateConfigs() {
		if (getInputVariables().isEmpty()) {
			return false;
		}
		for (InputVariable variable : getInputVariables()) {
			// If not all variables have a value, return false
			if (variable.getValues().isEmpty()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * {@link CollectionMutator} for the <code>variables</code>
	 * {@link Collection}, that aggregates both <code>inputVariables</code> and
	 * <code>outputVariables</code>. When modifications are asked, the first
	 * {@link Collection} whose type matches the type of the element is changed.
	 * 
	 * @author agomez
	 *
	 */
	private final class CompositeVariablesCollectionMutator implements CollectionMutator<Variable> {

		private static final long serialVersionUID = 1L;

		@Override
		public boolean add(CompositeCollection<Variable> composite, List<Collection<Variable>> collections, Variable obj) {
			for (Collection<Variable> collection : collections) {
				if (collection.toArray().getClass().getComponentType().isInstance(obj)) {
					return collection.add(obj);
				}
			}
			return false;
		}

		@Override
		public boolean addAll(CompositeCollection<Variable> composite, List<Collection<Variable>> collections, Collection<? extends Variable> coll) {
			boolean modified = false;
			for (Variable obj : coll) {
				for (Collection<Variable> collection : collections) {
					if (collection.toArray().getClass().getComponentType().isInstance(obj)) {
						modified |= collection.add(obj);
					}
				}
			}
			return modified;
		}

		@Override
		public boolean remove(CompositeCollection<Variable> composite, List<Collection<Variable>> collections, Object obj) {
			for (Collection<Variable> collection : collections) {
				if (collection.toArray().getClass().getComponentType().isInstance(obj)) {
					return collection.remove(obj);
				}
			}
			return false;
		}
	}

	/**
	 * {@link Function} that generates a <code>key</code> from
	 * {@link Variable#getName()}
	 * 
	 * @author agomez
	 *
	 * @param <I>
	 *            the actual subtype of {@link Variable} that will be used by
	 *            this {@link Function}
	 */
	private final class VarToKeyFunction<I extends Variable> implements Function<I, String> {
		@Override
		public String apply(I obj) {
			return obj != null ? obj.getName() : null;
		}
	}
}
