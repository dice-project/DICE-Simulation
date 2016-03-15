package es.unizar.disco.pnml.m2m.utils;

import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;

public class ErrorHandlingUtils {

	@Operation
	public static void abort(String cause) {
		throw new RuntimeException(cause);
	}
}
