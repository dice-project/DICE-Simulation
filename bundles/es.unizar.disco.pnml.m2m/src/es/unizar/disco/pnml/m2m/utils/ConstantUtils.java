package es.unizar.disco.pnml.m2m.utils;


import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;

public class ConstantUtils {

	public final static String TRANSITION_FAIL_TRACE = "FAIL";
	public final static String TRANSITION_OK_TRACE = "OK";
	public final static String PLACE_CONCURRENT_USERS_TRACE ="NumberOfConcurrentUsers";
	public final static String USERS = "Users";
	public final static String ALL_RESOURCES_FAILED = "AllResourcesFailed";
	
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
	
}
