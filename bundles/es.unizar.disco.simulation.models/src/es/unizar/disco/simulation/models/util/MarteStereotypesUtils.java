package es.unizar.disco.simulation.models.util;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.MARTE.MARTEPackage;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPlugin;
import org.eclipse.uml2.uml.util.UMLUtil;

public class MarteStereotypesUtils {

	/**
	 * Internal class extending {@link UMLUtil}, so that we can access its
	 * protected methods for convenience
	 * 
	 * @author agomez
	 *
	 */
	private static class InternalUMLUtil extends UMLUtil {

		private static final URI MARTE_PROFILE_URI = UMLPlugin.getEPackageNsURIToProfileLocationMap().get(MARTEPackage.eNS_URI);
		private static final EObject MARTE_EPACKAGE = new ResourceSetImpl().getResource(MARTE_PROFILE_URI, true).getEObject(MARTE_PROFILE_URI.fragment());

		protected static Stereotype getStereotype(EClass definition) {
			NamedElement namedElement = UMLUtil.getNamedElement(definition, MARTE_EPACKAGE);
			return namedElement instanceof Stereotype ? (Stereotype) namedElement : null;
		}
	}

	/**
	 * Internal class implementing a {@link Map} with a limited size
	 * 
	 * @author agomez
	 *
	 * @param <K>
	 * @param <V>
	 */
	private static class LimitedHashMap<K, V> extends LinkedHashMap<K, V> {

		private static final long serialVersionUID = 1L;

		private final int maxSize;

		public LimitedHashMap(int maxSize) {
			this.maxSize = maxSize;
		}

		@Override
		protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
			return size() > maxSize;
		}
	}

	private static final int MAX_CACHE_SIZE = 20;

	private static final Map<EClass, Stereotype> cache = new LimitedHashMap<>(MAX_CACHE_SIZE);

	/**
	 * Returns the MARTE {@link Stereotype} corresponding to the given
	 * implementation {@link EClass}
	 * 
	 * @param definition
	 *            an {@link EClass} belonging to any of the {@link EPackage}s
	 *            that implement the MARTE profile
	 * @return the Stereotype or <code>null</code> if no corresponding
	 *         {@link Stereotype} can be found
	 */
	private static Stereotype getStereotype(EClass definition) {
		Stereotype stereotype = cache.get(definition);
		if (stereotype == null) {
			stereotype = InternalUMLUtil.getStereotype(definition);
			// We store even those definitions for which no Stereotype can be
			// found
			// Stereotype information should not change during time, and thus,
			// looking up
			// for it several times does not make sense
			cache.put(definition, stereotype);
		}
		return stereotype;
	}

	/**
	 * Returns the Qualified Name of the stereotype corresponding to the given
	 * implementing {@link EClass}. This is a convenience method for invoking
	 * <code>MarteStereotypesUtils.getStereotype(eClass).getQualifiedName()</code>
	 * 
	 * @param definition
	 *            an {@link EClass} belonging to any of the {@link EPackage}s
	 *            that implement the MARTE profile
	 * @return the qualified name of the {@link Stereotype} or <code>null</code>
	 *         if no corresponding {@link Stereotype} can be found
	 */
	public static String getStereotypeQn(EClass definition) {
		Stereotype stereotype = getStereotype(definition);
		return stereotype != null ? stereotype.getQualifiedName() : null; //$NON-NLS-1$
	}

}