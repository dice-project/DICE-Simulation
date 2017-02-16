package es.unizar.disco.pnml.m2m.utils;

import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;

public class IdentifierUtils {

	private static final Map<Object, String> ids = Collections.synchronizedMap(new WeakHashMap<Object, String>());

	@Operation
	public static String createRandomUniqueId() {
		return EcoreUtil.generateUUID();
	}

	/**
	 * Returns a global <code>id</code> for the given {@link Object}. To avoid
	 * resources leakage, this method uses a {@link WeakHashMap} to store the
	 * already generated <code>ids</code>. Thus, it is only guaranteed to return
	 * the same <code>id</code> for the same passed {@link Object} when the
	 * {@link Object} is contained in a non-on-demand EMF {@link Resource}, such
	 * as the {@link XMIResource}
	 * 
	 * @param obj
	 * @return
	 */
	@Operation(contextual = true)
	public synchronized static String getEmfGlobalId(Object obj) {
		String id = ids.get(obj);
		if (id == null) {
			id = createRandomUniqueId();
			ids.put(obj, id);
		}
		return id;
	}

}
