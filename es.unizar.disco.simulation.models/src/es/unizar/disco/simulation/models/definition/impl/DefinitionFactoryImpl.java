/**
 */
package es.unizar.disco.simulation.models.definition.impl;

import es.unizar.disco.simulation.models.definition.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DefinitionFactoryImpl extends EFactoryImpl implements DefinitionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DefinitionFactory init() {
		try {
			DefinitionFactory theDefinitionFactory = (DefinitionFactory)EPackage.Registry.INSTANCE.getEFactory(DefinitionPackage.eNS_URI);
			if (theDefinitionFactory != null) {
				return theDefinitionFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DefinitionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefinitionFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DefinitionPackage.SIMULATION_DEFINITION: return createSimulationDefinition();
			case DefinitionPackage.SIMULATION_PARAMETER: return createSimulationParameter();
			case DefinitionPackage.INPUT_VARIABLE_VALUE: return createInputVariableValue();
			case DefinitionPackage.INPUT_VARIABLE: return createInputVariable();
			case DefinitionPackage.OUTPUT_VARIABLE: return createOutputVariable();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulationDefinition createSimulationDefinition() {
		SimulationDefinitionImpl simulationDefinition = new SimulationDefinitionImpl();
		return simulationDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulationParameter createSimulationParameter() {
		SimulationParameterImpl simulationParameter = new SimulationParameterImpl();
		return simulationParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputVariableValue createInputVariableValue() {
		InputVariableValueImpl inputVariableValue = new InputVariableValueImpl();
		return inputVariableValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputVariable createInputVariable() {
		InputVariableImpl inputVariable = new InputVariableImpl();
		return inputVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputVariable createOutputVariable() {
		OutputVariableImpl outputVariable = new OutputVariableImpl();
		return outputVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefinitionPackage getDefinitionPackage() {
		return (DefinitionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DefinitionPackage getPackage() {
		return DefinitionPackage.eINSTANCE;
	}

} //DefinitionFactoryImpl
