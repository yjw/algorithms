public class SegmentST {
    private int get_mid (int s, int t) {
        return (s + t) / 2;
    }
    
    public Node build (int l, int r) {
        Node root = new Node(l , r);
        if (l < r) {
            int mid = l + (r - l) / 2;
            root.left = build(l, mid);
            root.right = build(mid, r);
        }
        return root;
    }
    
    public void insert (int c, int d, Node root) {
        if (c <= root.lo && d >= root.hi) {
            root.cover++;
        }
        else {
            if (c < (root.lo + root.hi) / 2) {
                insert(c, d, root.left);
            }
            if (d > (root.lo + root.hi) / 2) {
                insert(c, d, root.right);
            }
        }
    }
    
    public void delete (int c, int d, Node root) {
        if (c <= root.lo && d >= root.hi) {
            root.cover--;
        }
        else {
            if (c < (root.lo + root.hi) / 2) {
                delete(c, d, root.left);
            }
            if (d > (root.lo + root.hi) / 2) {
                delete(c, d, root.right);
            }
        }
    }
}