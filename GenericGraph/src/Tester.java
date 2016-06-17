
public class Tester {
	public static void main(String[] args) {
		Graph<String> g = new ConcreteGraph<String>();
		String node = "node";
		String node2 = "node2";
		System.out.println("Adding node 1..");
		g.addNode(node);
		System.out.println("Graph has node 1: " + g.hasNode(node));
		System.out.println("Graph has node 2: " + g.hasNode(node2));
		System.out.println("Adding node 2..");
		g.addNode(node2);
		System.out.println("Graph has node 2: " + g.hasNode(node2));
		System.out.println("Edge between node 1 and node 2: " + g.hasEdge(node, node2));
		System.out.println("Edge between node 2 and node 1: " + g.hasEdge(node2, node));
		System.out.println("Adding edge between node 1 and node 2..");
		g.addEdge(node, node2);
		System.out.println("Edge between node 1 and node 2: " + g.hasEdge(node, node2));
		System.out.println("Edge between node 2 and node 1: " + g.hasEdge(node2, node));
		System.out.println("Removing edge between node 1 and node 2..");
		g.removeEdge(node2, node);
		System.out.println("Edge between node 1 and node 2: " + g.hasEdge(node, node2));
		System.out.println("Edge between node 2 and node 1: " + g.hasEdge(node2, node));
	}	
}
