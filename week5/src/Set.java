
public interface Set<E> extends Iterable<E> {
	boolean add(E element);
	void remove(E element);
	boolean contains(E element);
	Set<E> union(Set<E> set);
	Set<E> intersection(Set<E> set);
	/**
	 * Checks if this set is a subset of the set that is passed in
	 * @param set
	 * @return
	 */
	boolean isSubset(Set<E> set);
	boolean equals(Object o);
	void print();
}
