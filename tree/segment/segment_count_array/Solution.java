public class Solution {
	private Node build(int l, int r) {
		if (l > r) {
			return null;
		}
		if (l == r) {
			return new Node(l, r);
		}
		int mid = l + (r - l) / 2;
		Node root = new Node(l, r);
		int num_left = 0;
		int num_right = 0;
		root.left = build(l, mid);
		root.right = build(mid + 1, r);
		if (root.left != null) {
			num_left = root.left.num;
		}
		if (root.right != null) {
			num_right = root.right.num;
		}
		root.num = root.left.num + root.right.num;
		return root;
	}
	
	private int delete (Node root, int p) {
		root.num--;
		
		if (root.lo == root.hi) {
			//root.num--;
			return root.lo;
		}
		if (p < root.left.num) {
			return delete(root.left, p);
		}
		else {
			return delete(root.right, p - root.left.num);
		}
	}
	
	public int[] solve (int[] count) {
		int len = count.length;
		Node root = build(1, len);
		int[] res = new int[len];
		for (int i = 0; i < len; i++) {
			res[i] = delete(root, count[i]);
		}
		return res;
	}
}