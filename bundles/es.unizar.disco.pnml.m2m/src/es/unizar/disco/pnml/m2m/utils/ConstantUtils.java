package es.unizar.disco.pnml.m2m.utils;


import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;

public class ConstantUtils {

	private final static String TRANSITION_FAIL_TRACE = "FAIL";
	private final static String TRANSITION_OK_TRACE = "OK";
	private final static String PLACE_CONCURRENT_USERS_TRACE ="NumberOfConcurrentUsers";
	private final static String USERS = "Users";
	private final static String ALL_RESOURCES_FAILED = "AllResourcesFailed";
	private final static String ALL_RESOURCES_EXPELLED = "ResourcesExpelled";
	private final static String ALL_RESOURCES_NOT_EXPELLED = "ResourcesNotExpelled";
	
	
	@Operation
	public static String getUsers() {
		return USERS;
	}

	@Operation
	public static String getPlaceConcurrentUsersTrace() {
		return PLACE_CONCURRENT_USERS_TRACE;
	}

	@Operation
	public static String getFail() {
		return TRANSITION_FAIL_TRACE;
	}
	
	@Operation
	public static String getOK() {
		return TRANSITION_OK_TRACE;
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
	
}
