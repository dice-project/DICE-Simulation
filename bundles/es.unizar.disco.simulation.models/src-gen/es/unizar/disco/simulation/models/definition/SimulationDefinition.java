/**
 * Copyright (c) 2020 DisCo Group - Universidad de Zaragoza.
 * 
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-1.0/
 * 
 * SPDX-License-Identifier: EPL-1.0
 * 
 * Contributors:
 *     Abel Gómez
 *     Ignacio Requeno
 *     Diego Pérez
 */
package es.unizar.disco.simulation.models.definition;

import es.unizar.disco.simulation.models.datatypes.ComputableNFPtype;
import es.unizar.disco.simulation.models.datatypes.Resource;

import es.unizar.disco.simulation.models.invocation.SimulationInvocation;

import es.unizar.disco.simulation.models.measures.DomainMeasureDefinition;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simulation Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getInvocations <em>Invocations</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getParameters <em>Parameters</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getActiveScenario <em>Active Scenario</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getScenarios <em>Scenarios</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getInputVariables <em>Input Variables</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getDomainResource <em>Domain Resource</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getMaxExecutionTime <em>Max Execution Time</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getOutputVariables <em>Output Variables</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getDeclaredMeasures <em>Declared Measures</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getMeasuresToCompute <em>Measures To Compute</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getBackend <em>Backend</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getPossibleConfigurations <em>Possible Configurations</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getActiveConfigurations <em>Active Configurations</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#isAutoSync <em>Auto Sync</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getScenarioStereotypes <em>Scenario Stereotypes</em>}</li>
 *   <li>{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getNfpToCompute <em>Nfp To Compute</em>}</li>
 * </ul>
 *
 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getSimulationDefinition()
 * @model
 * @generated
 */
public interface SimulationDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' attribute.
	 * @see #setIdentifier(String)
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getSimulationDefinition_Identifier()
	 * @model id="true" required="true" derived="true"
	 * @generated
	 */
	String getIdentifier();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' attribute.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>Invocations</b></em>' reference list.
	 * The list contents are of type {@link es.unizar.disco.simulation.models.invocation.SimulationInvocation}.
	 * It is bidirectional and its opposite is '{@link es.unizar.disco.simulation.models.invocation.SimulationInvocation#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invocations</em>' reference list.
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getSimulationDefinition_Invocations()
	 * @see es.unizar.disco.simulation.models.invocation.SimulationInvocation#getDefinition
	 * @model opposite="definition" derived="true"
	 * @generated
	 */
	EList<SimulationInvocation> getInvocations();

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' map.
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getSimulationDefinition_Parameters()
	 * @model mapType="es.unizar.disco.simulation.models.definition.SimulationParameter&lt;org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString&gt;"
	 * @generated
	 */
	EMap<String, String> getParameters();

	/**
	 * Returns the value of the '<em><b>Active Scenario</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active Scenario</em>' reference.
	 * @see #setActiveScenario(EObject)
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getSimulationDefinition_ActiveScenario()
	 * @model required="true"
	 * @generated
	 */
	EObject getActiveScenario();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getActiveScenario <em>Active Scenario</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active Scenario</em>' reference.
	 * @see #getActiveScenario()
	 * @generated
	 */
	void setActiveScenario(EObject value);

	/**
	 * Returns the value of the '<em><b>Scenarios</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scenarios</em>' reference list.
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getSimulationDefinition_Scenarios()
	 * @model required="true" transient="true" derived="true"
	 * @generated
	 */
	EList<EObject> getScenarios();

	/**
	 * Returns the value of the '<em><b>Input Variables</b></em>' containment reference list.
	 * The list contents are of type {@link es.unizar.disco.simulation.models.definition.InputVariable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Variables</em>' containment reference list.
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getSimulationDefinition_InputVariables()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<InputVariable> getInputVariables();

	/**
	 * Returns the value of the '<em><b>Domain Resource</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Resource</em>' containment reference.
	 * @see #setDomainResource(Resource)
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getSimulationDefinition_DomainResource()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Resource getDomainResource();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getDomainResource <em>Domain Resource</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Resource</em>' containment reference.
	 * @see #getDomainResource()
	 * @generated
	 */
	void setDomainResource(Resource value);

	/**
	 * Returns the value of the '<em><b>Max Execution Time</b></em>' attribute.
	 * The default value is <code>"0000-00-00\'01:00:00"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Execution Time</em>' attribute.
	 * @see #setMaxExecutionTime(Date)
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getSimulationDefinition_MaxExecutionTime()
	 * @model default="0000-00-00\'01:00:00" required="true"
	 * @generated
	 */
	Date getMaxExecutionTime();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getMaxExecutionTime <em>Max Execution Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Execution Time</em>' attribute.
	 * @see #getMaxExecutionTime()
	 * @generated
	 */
	void setMaxExecutionTime(Date value);

	/**
	 * Returns the value of the '<em><b>Output Variables</b></em>' containment reference list.
	 * The list contents are of type {@link es.unizar.disco.simulation.models.definition.OutputVariable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Variables</em>' containment reference list.
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getSimulationDefinition_OutputVariables()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<OutputVariable> getOutputVariables();

	/**
	 * Returns the value of the '<em><b>Declared Measures</b></em>' containment reference list.
	 * The list contents are of type {@link es.unizar.disco.simulation.models.measures.DomainMeasureDefinition}.
	 * It is bidirectional and its opposite is '{@link es.unizar.disco.simulation.models.measures.DomainMeasureDefinition#getSimulationDefinition <em>Simulation Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declared Measures</em>' containment reference list.
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getSimulationDefinition_DeclaredMeasures()
	 * @see es.unizar.disco.simulation.models.measures.DomainMeasureDefinition#getSimulationDefinition
	 * @model opposite="simulationDefinition" containment="true" required="true"
	 * @generated
	 */
	EList<DomainMeasureDefinition> getDeclaredMeasures();

	/**
	 * Returns the value of the '<em><b>Measures To Compute</b></em>' reference list.
	 * The list contents are of type {@link es.unizar.disco.simulation.models.measures.DomainMeasureDefinition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measures To Compute</em>' reference list.
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getSimulationDefinition_MeasuresToCompute()
	 * @model required="true"
	 * @generated
	 */
	EList<DomainMeasureDefinition> getMeasuresToCompute();

	/**
	 * Returns the value of the '<em><b>Backend</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Backend</em>' attribute.
	 * @see #setBackend(String)
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getSimulationDefinition_Backend()
	 * @model required="true"
	 * @generated
	 */
	String getBackend();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getBackend <em>Backend</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Backend</em>' attribute.
	 * @see #getBackend()
	 * @generated
	 */
	void setBackend(String value);

	/**
	 * Returns the value of the '<em><b>Possible Configurations</b></em>' containment reference list.
	 * The list contents are of type {@link es.unizar.disco.simulation.models.definition.VariableConfiguration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Possible Configurations</em>' containment reference list.
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getSimulationDefinition_PossibleConfigurations()
	 * @model containment="true" derived="true"
	 * @generated
	 */
	EList<VariableConfiguration> getPossibleConfigurations();

	/**
	 * Returns the value of the '<em><b>Active Configurations</b></em>' reference list.
	 * The list contents are of type {@link es.unizar.disco.simulation.models.definition.VariableConfiguration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active Configurations</em>' reference list.
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getSimulationDefinition_ActiveConfigurations()
	 * @model
	 * @generated
	 */
	EList<VariableConfiguration> getActiveConfigurations();

	/**
	 * Returns the value of the '<em><b>Auto Sync</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Auto Sync</em>' attribute.
	 * @see #setAutoSync(boolean)
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getSimulationDefinition_AutoSync()
	 * @model default="false" required="true" transient="true"
	 * @generated
	 */
	boolean isAutoSync();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#isAutoSync <em>Auto Sync</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auto Sync</em>' attribute.
	 * @see #isAutoSync()
	 * @generated
	 */
	void setAutoSync(boolean value);

	/**
	 * Returns the value of the '<em><b>Scenario Stereotypes</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scenario Stereotypes</em>' attribute list.
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getSimulationDefinition_ScenarioStereotypes()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getScenarioStereotypes();

	/**
	 * Returns the value of the '<em><b>Nfp To Compute</b></em>' attribute.
	 * The literals are from the enumeration {@link es.unizar.disco.simulation.models.datatypes.ComputableNFPtype}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nfp To Compute</em>' attribute.
	 * @see es.unizar.disco.simulation.models.datatypes.ComputableNFPtype
	 * @see #setNfpToCompute(ComputableNFPtype)
	 * @see es.unizar.disco.simulation.models.definition.DefinitionPackage#getSimulationDefinition_NfpToCompute()
	 * @model
	 * @generated
	 */
	ComputableNFPtype getNfpToCompute();

	/**
	 * Sets the value of the '{@link es.unizar.disco.simulation.models.definition.SimulationDefinition#getNfpToCompute <em>Nfp To Compute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nfp To Compute</em>' attribute.
	 * @see es.unizar.disco.simulation.models.datatypes.ComputableNFPtype
	 * @see #getNfpToCompute()
	 * @generated
	 */
	void setNfpToCompute(ComputableNFPtype value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Aggregation of the {@link #getInputVariables()} and {@link #getOutputVariables()} {@link EStructuralFeature}s as a single {@link Collection}.
	 * Changes in the {@link Collection} are reflected in the underlying {@link EStructuralFeature}.
	 * <!-- end-model-doc -->
	 * @model kind="operation" dataType="es.unizar.disco.simulation.models.datatypes.Collection&lt;es.unizar.disco.simulation.models.definition.Variable&gt;"
	 * @generated
	 */
	Collection<Variable> getVariables();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@link Map} view of the {@link Collection} returned by {@link getVariables}.
	 * Changes in the {@link Map} are reflected in the underlying {@link Collection} and thus, to the underlying {@link EStructuralFeature}s.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Map<String, Variable> getVariablesMap();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@link Map} view of the {@link getInputVariables} {@link EStructuralFeature}.
	 * Changes in the {@link Map} are reflected in the underlying {@link EStructuralFeature}.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Map<String, InputVariable> getInputVariablesMap();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@link Map} view of the {@link getOutputVariables} {@link EStructuralFeature}.
	 * Changes in the {@link Map} are reflected in the underlying {@link EStructuralFeature}.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Map<String, OutputVariable> getOutputVariablesMap();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Synchronize the <code>Scenarios</code> information from the current {@link SimulationDefinition} {@link Resource}
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	void syncScenarios();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Synchronize the {@link Variable}s information from the <code>Scenario</code> returned by {@link #getActiveScenario()}
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	void syncVariables();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Synchronize the {@link DomainMeasuresDefinition}s information from the <code>Scenario</code> returned by {@link #getActiveScenario()}
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	void syncDomainMeasureDefinitions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void syncPossibleVariableConfigurations();

} // SimulationDefinition
