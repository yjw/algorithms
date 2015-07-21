package ds;

import java.util.Stack;
import java.util.Random;

public class Reservoir {
	private int count;
	private TreeNode res;
	public TreeNode sample (TreeNode root) {
		if (root == null) {
			return null;
		}
		count = 0;
		res = null;
		Random r = new Random();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			count++;
			int i = r.nextInt(count);
			if (i == 0) {
				res = curr;
			}
			if (curr.right != null) {
				stack.push(curr.right);
			}
			if (curr.left != null) {
				stack.push(curr.left);
			}
		}
		return res;
	}
}