// Temporary tester that breaks encapsulation and only works with the dummy Message class included
public class QueueTester {

	public static void main(String[] args) {
		MessageQueue q = new MessageQueue(5);
		q.printQueue();
		System.out.println("Adding elements");
		q.add(new Message("1"));
		q.add(new Message("2"));
		q.add(new Message("3"));
		q.add(new Message("4"));
		q.add(new Message("5"));
		q.add(new Message("6"));
		q.printQueue();
		System.out.println("Removed element: " + q.remove().getMessage());
		System.out.println("Removed element: " + q.remove().getMessage());
		q.printQueue();
		System.out.println("Adding elements");
		q.add(new Message("1"));
		q.add(new Message("1"));
		q.add(new Message("1"));
		q.printQueue();
	}

}
