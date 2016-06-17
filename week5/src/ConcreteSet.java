import java.util.ArrayList;
import java.util.Iterator;

public class ConcreteSet<E> implements Set<E> {
	ArrayList<E> elements;
	
	public ConcreteSet() {
		elements = new ArrayList<E>();
	}
	
	@Override
	public boolean add(E element) {
		if (!elements.contains(element)) {
			elements.add(element);
			return true;
		}
		return false;
	}
	
	@Override
	public void remove(E element) {
		elements.remove(element);
	}
	
	@Override
	public boolean contains(E element) {
		return elements.contains(element);
	}
	
	@Override
	public Set<E> union(Set<E> set) {
		Set<E> unionSet = new ConcreteSet<E>();
		for (E element : elements) {
			unionSet.add(element);
		}
		for (E element : set) {
			unionSet.add(element);
		}
		return unionSet;
	}

	@Override
	public Set<E> intersection(Set<E> set) {
		Set<E> intersectionSet = new ConcreteSet<E>();
		for (E element : elements) {
			if (set.contains(element)) {
				intersectionSet.add(element);
			}
		}
		return intersectionSet;
	}

	@Override
	public boolean isSubset(Set<E> set) {
		for (E element : elements) {
			if (!set.contains(element)) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || o.getClass()!=this.getClass()) return false;
		Set<E> that = (Set<E>) o;
		for (E element : this.elements) {
			if (!that.contains(element)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Iterator<E> iterator() {
		return elements.iterator();
	}
	
	public void print() {
		Iterator<E> i = this.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}
}
