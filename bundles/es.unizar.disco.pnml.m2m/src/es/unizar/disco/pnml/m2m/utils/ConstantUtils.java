package es.unizar.disco.pnml.m2m.utils;


import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;

public class ConstantUtils {

	public final static String TRANSITION_FAIL_TRACE = "FAIL";
	public final static String TRANSITION_OK_TRACE = "OK";
	
	@Operation
	public static String getFail() {
		return TRANSITION_FAIL_TRACE;
	}
	
	@Operation
	public static String getOK() {
		return TRANSITION_OK_TRACE;
	}
	
}
