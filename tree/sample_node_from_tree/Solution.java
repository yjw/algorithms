import java.util.Random;

public class Solution {
	public TreeNodeTotal rand_node(TreeNodeTotal root) {
		int k = num_of_nodes(root);
		Random r = new Random();
		int i = r.nextInt(k) + 1;
		
		TreeNodeTotal curr = root;
		while (curr != null) {
			System.out.println("i is " + i);
			if (curr.left == null) {
				if (i == 1) {
					return curr;
				}
				curr = curr.right;
				i--;
			}
			else if (curr.left.total == i - 1) {
				return curr;
			}
			else if (curr.left.total > i - 1) {
				curr = curr.left;
			}
			else {
				i = i - 1 - curr.left.total;
				curr = curr.right;
			}
		}
		return null;
	}
	private int num_of_nodes (TreeNodeTotal root) {
		if (root == null) {
			return 0;
		}
		root.total = num_of_nodes(root.left) + num_of_nodes(root.right) + 1;
		return root.total;
	}
}