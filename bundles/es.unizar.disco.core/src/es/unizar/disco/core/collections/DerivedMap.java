package es.unizar.disco.core.collections;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Quick, dirty and thread-unsafe implementation of a {@link Map} that stores
 * data in a backing {@link Collection}. <code>Values</code> correspond to the
 * entries of the {@link Collection}, <code>keys</code> are derived from a
 * {@link Function}. The {@link Function} must not generate the same
 * <code>key</code> for different <code>values</code> in the backing
 * {@link Collection}. <code>null</code> <code>keys</code> nor <code>null</code>
 * <code>values</code> are supported. Ignoring these rules may lead to
 * unexpected behavior.
 * 
 * 
 * @author agomez
 *
 * @param <K>
 *            key type
 * @param <V>
 *            value type, i.e., type of the backing {@link Collection}
 */
public class DerivedMap<K, V> extends AbstractMap<K, V> implements Map<K, V> {

	private Collection<V> backingCollection;

	private Function<V, K> keyFunction;

	public DerivedMap(Collection<V> backingCollection, Function<V, K> function) {
		this.backingCollection = backingCollection;
		this.keyFunction = function;
	}

	/**
	 * {@inheritDoc} Putting an existing value in an ordered backing
	 * {@link Collection} (e.g., a {@link List}) may change its position in it.
	 * The <code>key</code> must be {@link #equals(Object)} to the
	 * value computed from applying the <code>keyFunction</code> to
	 * <code>value</code>.
	 * 
	 * @throws NullPointerException
	 *             if the <code>key</code> is <code>null</code>
	 * @throws NullPointerException
	 *             if the <code>value</code> is <code>null</code>
	 * @throws IllegalArgumentException
	 *             if the <code>key</code> does not correspond to the computed
	 *             value from the <code>keyFunction</code> (i.e.,
	 *             <code>!key.equals(keyFunction.apply(value))</code>)
	 */
	@Override
	public V put(K key, V value) {
		if (key == null) {
			throw new NullPointerException("This Map implementation does not support 'null' keys");
		}
		if (value == null) {
			throw new NullPointerException("This Map implementation does not support 'null' values");
		}
		if (!key.equals(keyFunction.apply(value))) {
			throw new IllegalArgumentException("Computed key from 'value' does not match the 'key' argument");
		}
		V old = get(key);
		if (old != null) {
			backingCollection.remove(old);
		}
		backingCollection.add(value);
		return old;
	}

	@Override
	public Collection<V> values() {
		return backingCollection;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		return new DerivedEntrySet<K, V>(backingCollection, keyFunction);
	}

	private static class DerivedEntry<K, V> implements Entry<K, V> {

		private Function<V, K> keyFunction;

		private V value;

		public DerivedEntry(V value, Function<V, K> keyFunction) {
			this.value = value;
			this.keyFunction = keyFunction;
		}

		@Override
		public K getKey() {
			return value != null ? keyFunction.apply(value) : null;
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public V setValue(V value) {
			throw new UnsupportedOperationException();
		}
	}

	private static class DerivedEntrySet<K, V> extends AbstractSet<Entry<K, V>> implements Set<Entry<K, V>> {

		private Collection<V> backingCollection;

		private Function<V, K> keyFunction;

		public DerivedEntrySet(Collection<V> backingCollection, Function<V, K> keyFunction) {
			this.backingCollection = backingCollection;
			this.keyFunction = keyFunction;
		}

		@Override
		public int size() {
			return backingCollection.size();
		}

		@Override
		public Iterator<Entry<K, V>> iterator() {
			return new Iterator<Map.Entry<K, V>>() {

				Iterator<V> listIterator = backingCollection.iterator();

				@Override
				public boolean hasNext() {
					return listIterator.hasNext();
				}

				@Override
				public java.util.Map.Entry<K, V> next() {
					V value = listIterator.next();
					return new DerivedEntry<K, V>(value, keyFunction);
				}

				@Override
				public void remove() {
					listIterator.remove();
				}
			};
		}

		@Override
		public boolean add(java.util.Map.Entry<K, V> e) {
			return backingCollection.add(e.getValue());
		}
	}
}
