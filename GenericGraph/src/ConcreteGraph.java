import java.util.ArrayList;
import java.util.HashMap;

// Implementation of generic graph without relying on other classes
// Solution inspired by my comp2911 cohort
public class ConcreteGraph<E> implements Graph<E> {
	HashMap<E, ArrayList<E>> connections;
	
	public ConcreteGraph() {
		connections = new HashMap<E, ArrayList<E>>();
	}
	
	/**
	 * Adds a node to the graph if it is not already in the graph
	 * @param node
	 */
	@Override
	public void addNode(E node) {
		if (!connections.containsKey(node)) {
			connections.put(node, new ArrayList<E>());
		}
	}

	/**
	 * Adds an edge between two nodes
	 * @precondition hasNode(node1) && hasNode(node2)
	 * @precondition !node1.equals(node2)
	 * @postcondition hasEdge(node1, node2)
	 * @param node1
	 * @param node2
	 */
	@Override
	public void addEdge(E node1, E node2) {
		ArrayList<E> edges1 = connections.get(node1);
		ArrayList<E> edges2 = connections.get(node2);
		edges1.add(node2);
		edges2.add(node1);
		connections.put(node1, edges1);
		connections.put(node2, edges2);
	}
	
	/**
	 * Removes an edge between two nodes
	 * @precondition hasNode(node1) && hasNode(node2)
	 * @precondition !node1.equals(node2)
	 * @postcondition !hasEdge(node1, node2)
	 * @param node1
	 * @param node2
	 */
	@Override
	public void removeEdge(E node1, E node2) {
		ArrayList<E> edges1 = connections.get(node1);
		ArrayList<E> edges2 = connections.get(node2);
		edges1.remove(node2);
		edges2.remove(node1);
		connections.put(node1, edges1);
		connections.put(node2, edges2);
	}
	
	/**
	 * Checks whether the graph has the node
	 * @param node
	 * @return true if the graph has the node or false otherwise
	 */
	@Override
	public boolean hasNode(E node) {
		return connections.get(node) != null;
	}
	
	/**
	 * Checks whether the graph has an edge between node1 and node2
	 * @precondition hasNode(node1) && hasNode(node2)
	 * @param node1
	 * @param node2
	 * @return true if there is an edge between the two nodes or false otherwise
	 */
	@Override
	public boolean hasEdge(E node1, E node2) {
		return connections.get(node1).contains(node2);
	}
	
	/**
	 * Checks whether this graph is the same as the Object o
	 * @param o
	 * @return true if they are equal or false otherwise
	 */
	public boolean equals(Object o) {
		if (o == this) return true;
		if (o == null || o.getClass() != this.getClass()) return false;
		ConcreteGraph<?> that = (ConcreteGraph<?>)o;
		if (that.connections.equals(this.connections)) return true;
		return false;
	}
	
}
