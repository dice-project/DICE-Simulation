package es.unizar.disco.simulation.models.definition.impl;

import static org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage.Literals.GA_ANALYSIS_CONTEXT;
import static org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage.Literals.GA_ANALYSIS_CONTEXT__CONTEXT;
import static org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage.Literals.GA_SCENARIO;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

import es.unizar.disco.simulation.models.datatypes.DatatypesPackage;
import es.unizar.disco.simulation.models.definition.DefinitionFactory;
import es.unizar.disco.simulation.models.definition.InputVariable;
import es.unizar.disco.simulation.models.definition.InputVariableValue;
import es.unizar.disco.simulation.models.definition.OutputVariable;
import es.unizar.disco.simulation.models.definition.Variable;
import es.unizar.disco.simulation.models.util.MarteStereotypesUtils;

public class CustomSimulationDefinitionImpl extends SimulationDefinitionImpl {

	private static final String GA_ANALYSIS_CONTEXT_QN = MarteStereotypesUtils.getStereotypeQn(GA_ANALYSIS_CONTEXT);

	private static final String GA_SCENARIO_QN = MarteStereotypesUtils.getStereotypeQn(GA_SCENARIO);

	private AdapterImpl adapter = new AdapterImpl() {
		@Override
		public void notifyChanged(Notification msg) {
			if (msg.getFeature() == DatatypesPackage.Literals.RESOURCE__URI) {
				syncScenarios();
			}
		}
	};

	public void setDomainResource(es.unizar.disco.simulation.models.datatypes.Resource newDomainResource) {
		es.unizar.disco.simulation.models.datatypes.Resource oldDomainResource = super.getDomainResource();
		if (newDomainResource != oldDomainResource) {
			if (oldDomainResource != null) {
				oldDomainResource.eAdapters().remove(adapter);
			}
			super.setDomainResource(newDomainResource);
			if (newDomainResource != null) {
				newDomainResource.eAdapters().add(adapter);
			}
		}
	};

	@Override
	public void setActiveScenario(EObject newActiveScenario) {
		EObject oldActiveScenario = super.getActiveScenario();
		super.setActiveScenario(newActiveScenario);
		if (newActiveScenario != oldActiveScenario) {
			syncVariables();
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
				Stereotype gaScenarioStereotype = element.getApplicableStereotype(GA_SCENARIO_QN);
				if (element.isStereotypeApplied(gaScenarioStereotype)) {
					scenarios.add(eObject);
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
				
				// Collect new vars
				Set<Variable> newVariables = parseVariables(context);
				Map<String, Variable> newInVars = new HashMap<>();
				Map<String, Variable> newOutVars = new HashMap<>();
				for (Variable var : newVariables) {
					if (var instanceof InputVariable) { 
						newInVars.put(var.getName(), var);
					} else {
						newOutVars.put(var.getName(), var);
					}
				}

				// Cleanup old vars
				for (Iterator<Variable> it = getVariables().iterator(); it.hasNext();) {
					Variable var = it.next();
					boolean keep = false;
					if (var instanceof InputVariable && newInVars.containsKey(var.getName())) {
						keep = true;
					} else if (var instanceof OutputVariable && newOutVars.containsKey(var.getName())) {
						keep = true;
					}
					if (!keep) {
						it.remove();
					}
				}
				
				// Collect old vars that are still valid
				Set<String> aliveOldVars = new HashSet<>();
				for (Variable var : getVariables()) {
					aliveOldVars.add(var.getName());
				}
				
				// Add remaining new vars
				for (Variable var : newVariables) {
					if (!aliveOldVars.contains(var.getName())) {
						getVariables().add(var);
					}
				}
			}
		}
	}

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
						((InputVariable)variable).getValues().add(variableValue);
					}
				}
				variable.setName(name);
				variables.add(variable);
				
			}
		}
		return variables;
	}
	
	@Override
	public Variable getVariable(String name) {
		for (Variable var : getVariables()) {
			if (name.equals(var.getName())) {
				return var;
			}
		}
		return null;
	}
}
