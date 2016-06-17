
public interface Graph<E> {
	// class invariant hasEdge(node1, node2) == hasEdge(node2, node1)
	void addNode(E node);
	void addEdge(E node1, E node2);
	void removeEdge(E node1, E node2);
	boolean hasNode(E node);
	boolean hasEdge(E node1, E node2);
}
