/*******************************************************************************
 * Copyright (c) 2020 DisCo Group - Universidad de Zaragoza.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-1.0/
 *
 * SPDX-License-Identifier: EPL-1.0
 *
 * Contributors:
 *     Abel Gómez
 *     Ignacio Requeno
 *     Diego Pérez
 *******************************************************************************/
package es.unizar.disco.core.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionUtils {

	/*
	 * This class was previously used in 
	 * /es.unizar.disco.simulation.models/src/es/unizar/disco/simulation/models/definition/impl/CustomSimulationDefinitionImpl.java
	 * but now has been replaced by a dependency from google Guava
	 */
	@SafeVarargs
	public static <E> Collection<Collection<E>> cartesianProduct(Collection<E> ... collections) {
		// Convert collections to Lists to safely iterate
		List<List<E>> lists = new ArrayList<>(collections.length);
		for (int i = 0; i < collections.length; i++) {
			if (collections[i].isEmpty()) {
				throw new IllegalArgumentException("Input collections must not be empty");
			}
			lists.add(new ArrayList<E>(collections[i]));
		}

		List<Collection<E>> result = new ArrayList<>();
		int[] indexes = new int[collections.length]; // Indexes are initilized to 0 according to the spec
		boolean finished;
		do {
			finished = true;
			List<E> combination = new ArrayList<>();
			for (int i = 0; i < lists.size(); i++) {
				combination.add(lists.get(i).get(indexes[i]));
			}
			result.add(combination);
			for (int i = 0; i < indexes.length; i++) {
				if (indexes[i] < collections[i].size() - 1) {
					indexes[i]++;
					finished = false;
					break;
				}
			}
		} while (!finished);
		return result;
	}

}
