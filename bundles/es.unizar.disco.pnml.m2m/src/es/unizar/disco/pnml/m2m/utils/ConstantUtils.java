package es.unizar.disco.pnml.m2m.utils;


import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;

public class ConstantUtils {

	private final static String TRANSITION_END_SEQUENCE = "transitionEndSequenceDiagram";
	private final static String TRANSITION_FAIL_TRACE = "FAIL";
	private final static String TRANSITION_OK_TRACE = "OK";
	private final static String TRANSITION_STORM_SPOUT = "TimedTransitionSpout";
	private final static String PLACE_CONCURRENT_USERS_TRACE ="NumberOfConcurrentUsers";
	private final static String PLACE_INMPLICIT_SEQUENCE_DIAGRAM ="ImplicitPlace";
	private final static String USERS = "Users";
	private final static String ALL_RESOURCES_FAILED = "AllResourcesFailed";
	private final static String ALL_RESOURCES_EXPELLED = "ResourcesExpelled";
	private final static String ALL_RESOURCES_NOT_EXPELLED = "ResourcesNotExpelled";
	private final static String MASTER_FAILS = "MasterNodeFails";
	private final static String MASTER_REPAIRS = "MasterNodeRepairs";
	private final static String MISSION_TIME = "missionTime";
	private final static String VMS_ACTIVE = "activeVms";
	private final static String MTTF_VMS = "transitionWithMTTFvms";
	
	
	@Operation
	public static String getUsers() {
		return USERS;
	}

	@Operation
	public static String getImplicitPlaceSequenceDiagram() {
		return PLACE_INMPLICIT_SEQUENCE_DIAGRAM;
	}
	
	public static String getPlaceConcurrentUsersTrace() {
		return PLACE_CONCURRENT_USERS_TRACE;
	}

	@Operation
	public static String getTransitionEndSequence() {
		return TRANSITION_END_SEQUENCE;
	}
	
	public static String getFail() {
		return TRANSITION_FAIL_TRACE;
	}
	
	@Operation
	public static String getOK() {
		return TRANSITION_OK_TRACE;
	}
	
	@Operation
	public static String getTransitionStormSpout() {
		return TRANSITION_STORM_SPOUT;
	}

	
	@Operation
	public static String getTransitionAllFailedTrace() {
		return ALL_RESOURCES_FAILED;
	}
	
	@Operation
	public static String getPlaceAllExpelled() {
		return ALL_RESOURCES_EXPELLED;
	}
	
	@Operation
	public static String getPlaceNotExpelled() {
		return ALL_RESOURCES_NOT_EXPELLED;
	}
	
	@Operation
	public static String getTransitionMasterFails() {
		return MASTER_FAILS;
	}
	
	@Operation
	public static String getTransitionMasterRepairs() {
		return MASTER_REPAIRS;
	}
	
	@Operation
	public static String getMissionTime() {
		return MISSION_TIME;
	}
	
	@Operation
	public static String getVmsActive(){
		return VMS_ACTIVE;
	}
	
	@Operation
	public static String getMTTFvms(){
		return MTTF_VMS;
	}
	
}
