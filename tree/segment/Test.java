import java.util.Queue;
import java.util.LinkedList;

public class Test {
	public static void main (String[] args) {
		Solution s = new Solution();
		Node m = s.build(0, 4);
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(m);
		int current = 1;
		int next = 0;
		//s.insert(2, 2, m);
		while (!queue.isEmpty()) {
			Node n = queue.poll();
			System.out.print("[" + n.lo + ", " + n.hi + "]" + "  " + "c " + n.cover);
			if (n.left != null) {
				queue.offer(n.left);
				next++;
			}
			if (n.right != null) {
				queue.offer(n.right);
				next++;
			}
			current--;
			if (current == 0) {
				current = next;
				next = 0;
				System.out.println();
			}
		}
	}
}