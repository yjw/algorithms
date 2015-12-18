import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MinQueue {
	private Queue<Integer> queue;
	private Deque<Integer> min;
	
	MinQueue() {
		queue = new LinkedList<Integer>();
		min = new LinkedList<Integer>();
	}
	
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public boolean offer(int i) {
		boolean b = queue.offer(i);
		while (!min.isEmpty() && min.getLast() > i) {
			min.pollLast();
		}
		min.offer(i);
		return b;
	}

	public int poll() {
		int temp = queue.poll();
		if (temp == min.peek()) {
			min.poll();
		}
		return temp;
	}
	
	public int peek() {
		return queue.poll();
	}
	
	public int min() {
		return min.peekFirst();
	}
}
