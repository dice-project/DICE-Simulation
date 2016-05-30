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
	 * The '<em><b>Ga Scenario througput</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GA_SCENARIO_THROUGPUT_VALUE
	 * @generated
	 * @ordered
	 */
	GA_SCENARIO_THROUGPUT(1, "GaScenario_througput", "MARTE::MARTE_AnalysisModel::GQAM::GaScenario#throughput"),

	/**
	 * The '<em><b>Ga Scenario utilization</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GA_SCENARIO_UTILIZATION_VALUE
	 * @generated
	 * @ordered
	 */
	GA_SCENARIO_UTILIZATION(2, "GaScenario_utilization", "MARTE::MARTE_AnalysisModel::GQAM::GaScenario#utilization"),

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
	 * The '<em><b>Ga Step througput</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GA_STEP_THROUGPUT_VALUE
	 * @generated
	 * @ordered
	 */
	GA_STEP_THROUGPUT(11, "GaStep_througput", "MARTE::MARTE_AnalysisModel::GQAM::GaStep#throughput"),

	/**
	 * The '<em><b>Ga Step utilization</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GA_STEP_UTILIZATION_VALUE
	 * @generated
	 * @ordered
	 */
	GA_STEP_UTILIZATION(12, "GaStep_utilization", "MARTE::MARTE_AnalysisModel::GQAM::GaStep#utilization");

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
	 * The '<em><b>Ga Scenario througput</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ga Scenario througput</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GA_SCENARIO_THROUGPUT
	 * @model name="GaScenario_througput" literal="MARTE::MARTE_AnalysisModel::GQAM::GaScenario#throughput"
	 * @generated
	 * @ordered
	 */
	public static final int GA_SCENARIO_THROUGPUT_VALUE = 1;

	/**
	 * The '<em><b>Ga Scenario utilization</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ga Scenario utilization</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GA_SCENARIO_UTILIZATION
	 * @model name="GaScenario_utilization" literal="MARTE::MARTE_AnalysisModel::GQAM::GaScenario#utilization"
	 * @generated
	 * @ordered
	 */
	public static final int GA_SCENARIO_UTILIZATION_VALUE = 2;

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
	 * The '<em><b>Ga Step througput</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ga Step througput</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GA_STEP_THROUGPUT
	 * @model name="GaStep_througput" literal="MARTE::MARTE_AnalysisModel::GQAM::GaStep#throughput"
	 * @generated
	 * @ordered
	 */
	public static final int GA_STEP_THROUGPUT_VALUE = 11;

	/**
	 * The '<em><b>Ga Step utilization</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ga Step utilization</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GA_STEP_UTILIZATION
	 * @model name="GaStep_utilization" literal="MARTE::MARTE_AnalysisModel::GQAM::GaStep#utilization"
	 * @generated
	 * @ordered
	 */
	public static final int GA_STEP_UTILIZATION_VALUE = 12;

	/**
	 * An array of all the '<em><b>Supported Metrics</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SupportedMetrics[] VALUES_ARRAY =
		new SupportedMetrics[] {
			GA_SCENARIO_RESP_T,
			GA_SCENARIO_THROUGPUT,
			GA_SCENARIO_UTILIZATION,
			GA_STEP_RESP_T,
			GA_STEP_THROUGPUT,
			GA_STEP_UTILIZATION,
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
			case GA_SCENARIO_THROUGPUT_VALUE: return GA_SCENARIO_THROUGPUT;
			case GA_SCENARIO_UTILIZATION_VALUE: return GA_SCENARIO_UTILIZATION;
			case GA_STEP_RESP_T_VALUE: return GA_STEP_RESP_T;
			case GA_STEP_THROUGPUT_VALUE: return GA_STEP_THROUGPUT;
			case GA_STEP_UTILIZATION_VALUE: return GA_STEP_UTILIZATION;
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
