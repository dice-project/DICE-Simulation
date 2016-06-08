/**
 */
package es.unizar.disco.simulation.models.marteconstants;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Supported Metrics</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * EEnum containing the constants of Stereotypes which represent supported metrics.
 * An entry must be created for each supported metric. The literal value of the entry will contain the stereotype FQN and the tagged value in the form "fqn#tagged-value", e.g. "MARTE::MARTE_AnalysisModel::GQAM::GaScenario#respT".
 * Only explicitly declared stereotypes will be considered as supported, i.e., a substereotype will not be considered as supported if it is not explicitly declared (e.g. GaStep must be explicitly declared as supported although it inherits from GaScenario).
 * 
 * <!-- end-model-doc -->
 * @see es.unizar.disco.simulation.models.marteconstants.MarteconstantsPackage#getSupportedMetrics()
 * @model
 * @generated
 */
public enum SupportedMetrics implements Enumerator {
	/**
	 * The '<em><b>Ga Scenario resp T</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GA_SCENARIO_RESP_T_VALUE
	 * @generated
	 * @ordered
	 */
	GA_SCENARIO_RESP_T(0, "GaScenario_respT", "MARTE::MARTE_AnalysisModel::GQAM::GaScenario#respT"),

	/**
	 * The '<em><b>Ga Scenario throughput</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GA_SCENARIO_THROUGHPUT_VALUE
	 * @generated
	 * @ordered
	 */
	GA_SCENARIO_THROUGHPUT(1, "GaScenario_throughput", "MARTE::MARTE_AnalysisModel::GQAM::GaScenario#throughput"),

	/**
	 * The '<em><b>Ga Step resp T</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GA_STEP_RESP_T_VALUE
	 * @generated
	 * @ordered
	 */
	GA_STEP_RESP_T(10, "GaStep_respT", "MARTE::MARTE_AnalysisModel::GQAM::GaStep#respT"),

	/**
	 * The '<em><b>Ga Step throughput</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GA_STEP_THROUGHPUT_VALUE
	 * @generated
	 * @ordered
	 */
	GA_STEP_THROUGHPUT(11, "GaStep_throughput", "MARTE::MARTE_AnalysisModel::GQAM::GaStep#throughput"),

	/**
	 * The '<em><b>Pa Logical Resource utilization</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PA_LOGICAL_RESOURCE_UTILIZATION_VALUE
	 * @generated
	 * @ordered
	 */
	PA_LOGICAL_RESOURCE_UTILIZATION(20, "PaLogicalResource_utilization", "MARTE::MARTE_AnalysisModel::PAM::PaLogicalResource#utilization"),

	/**
	 * The '<em><b>Ga Exec Host utilization</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GA_EXEC_HOST_UTILIZATION_VALUE
	 * @generated
	 * @ordered
	 */
	GA_EXEC_HOST_UTILIZATION(30, "GaExecHost_utilization", "MARTE::MARTE_AnalysisModel::GQAM::GaExecHost#utilization"),

	/**
	 * The '<em><b>Ga Comm Host utilization</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GA_COMM_HOST_UTILIZATION_VALUE
	 * @generated
	 * @ordered
	 */
	GA_COMM_HOST_UTILIZATION(40, "GaCommHost_utilization", "MARTE::MARTE_AnalysisModel::GQAM::GaCommHost#utilization");

	/**
	 * The '<em><b>Ga Scenario resp T</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ga Scenario resp T</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GA_SCENARIO_RESP_T
	 * @model name="GaScenario_respT" literal="MARTE::MARTE_AnalysisModel::GQAM::GaScenario#respT"
	 * @generated
	 * @ordered
	 */
	public static final int GA_SCENARIO_RESP_T_VALUE = 0;

	/**
	 * The '<em><b>Ga Scenario throughput</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ga Scenario throughput</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GA_SCENARIO_THROUGHPUT
	 * @model name="GaScenario_throughput" literal="MARTE::MARTE_AnalysisModel::GQAM::GaScenario#throughput"
	 * @generated
	 * @ordered
	 */
	public static final int GA_SCENARIO_THROUGHPUT_VALUE = 1;

	/**
	 * The '<em><b>Ga Step resp T</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ga Step resp T</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GA_STEP_RESP_T
	 * @model name="GaStep_respT" literal="MARTE::MARTE_AnalysisModel::GQAM::GaStep#respT"
	 * @generated
	 * @ordered
	 */
	public static final int GA_STEP_RESP_T_VALUE = 10;

	/**
	 * The '<em><b>Ga Step throughput</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ga Step throughput</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GA_STEP_THROUGHPUT
	 * @model name="GaStep_throughput" literal="MARTE::MARTE_AnalysisModel::GQAM::GaStep#throughput"
	 * @generated
	 * @ordered
	 */
	public static final int GA_STEP_THROUGHPUT_VALUE = 11;

	/**
	 * The '<em><b>Pa Logical Resource utilization</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Pa Logical Resource utilization</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PA_LOGICAL_RESOURCE_UTILIZATION
	 * @model name="PaLogicalResource_utilization" literal="MARTE::MARTE_AnalysisModel::PAM::PaLogicalResource#utilization"
	 * @generated
	 * @ordered
	 */
	public static final int PA_LOGICAL_RESOURCE_UTILIZATION_VALUE = 20;

	/**
	 * The '<em><b>Ga Exec Host utilization</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ga Exec Host utilization</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GA_EXEC_HOST_UTILIZATION
	 * @model name="GaExecHost_utilization" literal="MARTE::MARTE_AnalysisModel::GQAM::GaExecHost#utilization"
	 * @generated
	 * @ordered
	 */
	public static final int GA_EXEC_HOST_UTILIZATION_VALUE = 30;

	/**
	 * The '<em><b>Ga Comm Host utilization</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ga Comm Host utilization</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GA_COMM_HOST_UTILIZATION
	 * @model name="GaCommHost_utilization" literal="MARTE::MARTE_AnalysisModel::GQAM::GaCommHost#utilization"
	 * @generated
	 * @ordered
	 */
	public static final int GA_COMM_HOST_UTILIZATION_VALUE = 40;

	/**
	 * An array of all the '<em><b>Supported Metrics</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SupportedMetrics[] VALUES_ARRAY =
		new SupportedMetrics[] {
			GA_SCENARIO_RESP_T,
			GA_SCENARIO_THROUGHPUT,
			GA_STEP_RESP_T,
			GA_STEP_THROUGHPUT,
			PA_LOGICAL_RESOURCE_UTILIZATION,
			GA_EXEC_HOST_UTILIZATION,
			GA_COMM_HOST_UTILIZATION,
		};

	/**
	 * A public read-only list of all the '<em><b>Supported Metrics</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<SupportedMetrics> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Supported Metrics</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static SupportedMetrics get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SupportedMetrics result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Supported Metrics</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static SupportedMetrics getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SupportedMetrics result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Supported Metrics</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static SupportedMetrics get(int value) {
		switch (value) {
			case GA_SCENARIO_RESP_T_VALUE: return GA_SCENARIO_RESP_T;
			case GA_SCENARIO_THROUGHPUT_VALUE: return GA_SCENARIO_THROUGHPUT;
			case GA_STEP_RESP_T_VALUE: return GA_STEP_RESP_T;
			case GA_STEP_THROUGHPUT_VALUE: return GA_STEP_THROUGHPUT;
			case PA_LOGICAL_RESOURCE_UTILIZATION_VALUE: return PA_LOGICAL_RESOURCE_UTILIZATION;
			case GA_EXEC_HOST_UTILIZATION_VALUE: return GA_EXEC_HOST_UTILIZATION;
			case GA_COMM_HOST_UTILIZATION_VALUE: return GA_COMM_HOST_UTILIZATION;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private SupportedMetrics(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //SupportedMetrics
