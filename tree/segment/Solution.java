public class Solution {
	private int get_mid (int l, int r) {
		return l + (r - l) / 2;
	}
	public Node build (int l, int r) {
		if (l == r) {
			Node leaf = new Node(l, l);
			return leaf;
		}
		Node root = new Node(l, r);
		int mid = get_mid(l , r);
		root.left = build(l, mid);
		root.right = build(mid + 1, r);
		return root;
	}
	
	public void insert (int l, int r, Node root) {
		if (l <= root.lo && r >= root.hi) {
			root.cover++;
		}
		else {
			if (l <= root.lo + (root.hi - root.lo) / 2) {
				insert(l, r, root.left);
			}
			if (r >= root.lo + (root.hi - root.lo) / 2) {
				insert(l, r, root.right);
			}
		}
	}
	
	public void delete (int l, int r, Node root) {
		if (l <= root.lo && r >= root.hi) {
            root.cover--;
        }
        else {
            if (l < (root.lo + root.hi) / 2) {
                delete(l, r, root.left);
            }
            if (r > (root.lo + root.hi) / 2) {
                delete(l, r, root.right);
            }
        }
	}
}