import java.util.ArrayList;

public class MessageQueue {
	private static int MAX_SIZE;
	private Message queue[];
	private int head;
	private int tail;
	
	/**
	 * Creates a new Message Queue
	 */
	public MessageQueue(int size) {
		MAX_SIZE = size;
		queue = new Message[MAX_SIZE];
		head = 0;
		tail = 0;
	}

	/**
	 * @precondition 
	 * 0 <= head < MAX_SIZE
	 * 0 <= tail < MAX_SIZE
	 * @postcondition
	 * 0 <= head < MAX_SIZE
	 * 0 <= tail < MAX_SIZE
	 * queue[(tail-1)%MAX_SIZE] == m
	 * @param m
	 */
	public void add(Message m) {
		if (tail == head && queue[head]!=null) {
			head = (head+1)%MAX_SIZE;
		}
		queue[tail] = m;
		tail = (tail+1)%MAX_SIZE;
	}
	
	/**
	 * @precondition 
	 * 0 <= head < MAX_SIZE
	 * 0 <= tail < MAX_SIZE
	 * @postcondition
	 * 0 <= head < MAX_SIZE
	 * 0 <= tail < MAX_SIZE
	 * queue[tail)%MAX_SIZE] == null
	 */
	public Message remove() {
		if (queue[head] == null) {
			return null;
		}
		if (tail == head && queue[head]==null) {
			tail = (tail+1)%MAX_SIZE;
		}
		Message m = queue[head];
		queue[head] = null;
		head = (head+1)%MAX_SIZE;		
		return m;
	}
	
	/**
	 * Prints out all the elements of the queue.
	 * This method is for testing purposes only and may not work once Message is implemented
	 */
	public void printQueue() {
		int i = 0;
		System.out.println("Elements in queue:");
		while (i < MAX_SIZE) {
			if (queue[(head+i)%MAX_SIZE] != null) {
				System.out.println(queue[(head+i)%MAX_SIZE].getMessage());
			}
			i++;
		}
	}
}
