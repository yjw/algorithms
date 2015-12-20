import java.util.Queue;
import java.util.LinkedList;

public class Solution {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}

		Queue<TreeNode> leftq = new LinkedList<TreeNode>();
		Queue<TreeNode> rightq = new LinkedList<TreeNode>();
		leftq.offer(root.left);
		rightq.offer(root.right);
		while (!leftq.isEmpty() && !rightq.isEmpty()) {
			TreeNode node1 = leftq.poll();
			TreeNode node2 = rightq.poll();
			if (node1 == null && node2 == null) {
				continue;
			}
			if (node1 == null || node2 == null || node1.val != node2.val) {
				return false;
			}
			leftq.offer(node1.left);
			rightq.offer(node2.right);
			leftq.offer(node1.right);
			rightq.offer(node2.left);
		}
		return leftq.isEmpty() && rightq.isEmpty();
	}
}
