package es.unizar.disco.core.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionUtils {

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
