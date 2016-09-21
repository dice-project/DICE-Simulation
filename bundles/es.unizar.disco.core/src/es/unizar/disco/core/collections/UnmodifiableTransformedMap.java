package es.unizar.disco.core.collections;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Unmodifiable {@link Map} that is built from an existing {@link Map}.
 * The new {@link Map} maintains the same <code>keys</code> than the original
 * {@link Map}. The <code>values</code> are obtained by applying a
 * transformation {@link Function} to the values of the original {@link Map}
 * 
 * @author agomez
 *
 * @param <K>
 *            the type of the <code>key</code>
 * @param <V1>
 *            the type of the <code>values</code> of the original {@link Map}
 * @param <V2>
 *            the type of the <code>values</code> of this {@link Map}
 */
public class UnmodifiableTransformedMap<K, V1, V2> implements Map<K, V2> {

	private Map<K, V2> internalMap;

	public UnmodifiableTransformedMap(Map<K, V1> map, Function<V1, V2> valueFunction) {
		Map<K, V2> modifiable = new HashMap<K, V2>();
		for (Entry<K, V1> entry : map.entrySet()) {
			modifiable.put(entry.getKey(), valueFunction.apply(entry.getValue()));
		}
		internalMap = Collections.unmodifiableMap(modifiable);
	}

	public int size() {
		return internalMap.size();
	}

	public boolean isEmpty() {
		return internalMap.isEmpty();
	}

	public boolean containsKey(Object key) {
		return internalMap.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return internalMap.containsValue(value);
	}

	public V2 get(Object key) {
		return internalMap.get(key);
	}

	public V2 put(K key, V2 value) {
		return internalMap.put(key, value);
	}

	public V2 remove(Object key) {
		return internalMap.remove(key);
	}

	public void putAll(Map<? extends K, ? extends V2> m) {
		internalMap.putAll(m);
	}

	public void clear() {
		internalMap.clear();
	}

	public Set<K> keySet() {
		return internalMap.keySet();
	}

	public Collection<V2> values() {
		return internalMap.values();
	}

	public Set<java.util.Map.Entry<K, V2>> entrySet() {
		return internalMap.entrySet();
	}

	public boolean equals(Object o) {
		return internalMap.equals(o);
	}

	public int hashCode() {
		return internalMap.hashCode();
	}

}
