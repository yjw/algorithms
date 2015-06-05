import java.util.HashMap;

public class Test {
	public static void main (String[] args) {
		Solution s = new Solution();
		HashMap<Integer, Integer> node = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> val = new HashMap<Integer, Integer>();
		node.put(0, -1);
		node.put(1, 0);
		node.put(2, 0);
		node.put(3, 1);
		node.put(4, 1);
		node.put(5, 4);
		node.put(6, 4);
		node.put(7, 5);
		
		val.put(0, 1);
		val.put(1, 2);
		val.put(2, 3);
		val.put(3, 4);
		val.put(4, 5);
		val.put(5, 6);
		val.put(6, 7);
		val.put(7, 8);
		System.out.println("blalbla" + s.sum(node, val));
	}
}