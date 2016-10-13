package es.unizar.disco.pnml.m2t.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import fr.lip6.move.pnml.ptnet.PetriNet;
import fr.lip6.move.pnml.ptnet.Place;
import fr.lip6.move.pnml.ptnet.PnObject;
import fr.lip6.move.pnml.ptnet.Transition;

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

	private Map<Integer, Integer> groupPriorityRegistry = new HashMap<Integer, Integer>();
	private int indexToAdd = 1;

	/**
	 * This method traverses all the transitions in pn and creates an entry in
	 * the map for each different priority
	 * 
	 * @param pn
	 * @return the number of different priorities
	 */
	public Integer countGroups(PetriNet pn) {
		Set<Integer> setPriorities = new HashSet<Integer>();
		setPriorities.add(1);
		List<PnObject> pnObjects = pn.getPages().get(0).getObjects();
		for (PnObject object : pnObjects) {
			try {
				Transition trans = (Transition) object;
				Integer priority = PnmlToolInfoUtils.getTransitionPriority(trans);
				if (!setPriorities.contains(priority)) {
					setPriorities.add(priority);
				}
			} catch (ClassCastException e) {
				// the element wasn't a transition. Nothing to do, try with the
				// next element
			}

		}
		return setPriorities.size();
	}

	/**
	 * @param trans transition to check whether its priority has been added
	 * @return whether the transition priority had been treated before
	 */
	public boolean priorityNotAdded(Transition trans) {
	/*	if (groupPriorityRegistry.isEmpty()) {
			groupPriorityRegistry.put(1, indexToAdd);
			indexToAdd++;
		}*/
		return ! groupPriorityRegistry.containsKey(PnmlToolInfoUtils.getTransitionPriority(trans));
	}

	public void addPriority(Transition trans) {
		groupPriorityRegistry.put(PnmlToolInfoUtils.getTransitionPriority(trans), indexToAdd);
		indexToAdd++;
	}
	
	public Integer getPriorityIndex(Transition trans){
		return groupPriorityRegistry.get(PnmlToolInfoUtils.getTransitionPriority(trans));
	}

		
}
