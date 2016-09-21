package es.unizar.disco.pnml.m2t.utils;

import java.util.HashMap;

import org.eclipse.emf.ecore.EObject;

import fr.lip6.move.pnml.ptnet.Place;

/**
 * Registry that records the order in which {@link Place}s are processed by the
 * Acceleo transformation. This is required since GreatSPN identifies elements
 * in the <code>.net</code> file by their order in it.
 * 
 * @author Abel Gómez <abel.gomez@unizar.es>
 *
 */
public class PlaceRegistry {

	private HashMap<EObject, Integer> placeRegistry = new HashMap<>();
	private int lastIndex = 0;

	public void registerPlace(EObject pnObject) {
		Integer index = placeRegistry.get(pnObject);
		if (index == null) {
			placeRegistry.put(pnObject, ++lastIndex);
		}
	}

	public Integer getPlaceIndex(EObject pnObject) {
		return placeRegistry.get(pnObject);
	}
}
