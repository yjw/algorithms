import java.util.HashSet;

public class LCA {
    public TreeNodeP ancesterI(TreeNodeP p, TreeNodeP q) {
        HashSet<TreeNodeP> set = new HashSet<TreeNodeP>();
        while (p != null || q != null) {
            if (p != null) {
                if (set.contains(p)) {
                    return p;
                }
                p = p.parent;
            }
            if (q != null) {
                if (set.contains(q)) {
                    return q;
                }
                q = q.parent;
            }
        }
        return null;
    }
    
    public TreeNodeP ancesterII(TreeNodeP p, TreeNodeP q) {
        int p_depth = 0, q_depth = 0;
        TreeNodeP tp = p, tq = q;
        while (tp != null || tq != null) {
            if (tp != null) {
                tp = tp.parent;
                p_depth++;
            }
            if (tq != null) {
                tq = tq.parent;
                q_depth++;
            }
        }
        if (p_depth < q_depth) {
            TreeNodeP temp = p;
            p = q;
            q = temp;
        }
        int diff = Math.abs(p_depth - q_depth);
        while (diff > 0) {
            p = p.parent;
            diff--;
        }
        while (p != null && q != null) {
            if (p == q) {
                return p;
            }
            p = p.parent;
            q = q.parent;
        }
        return null;
    }
    
    public TreeNode ancestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        int total = matches(root.left, p, q);
        if (total == 1) {
            return root;
        }
        else if (total == 2) {
            return ancestor(root.left, p, q);
        }
        else {
            return ancestor(root.right, p, q);
        }
    }
    
    private int matches (TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return 0;
        }
        int mat = matches(root.left, p, q) + matches(root.right, p, q);
        if (root == p || root == q) {
            return mat + 1;
        }
        else {
            return mat;
        }
    }
    
    public TreeNode ancestorI(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode L = ancestor(root.left, p, q);
        TreeNode R = ancestor(root.right, p, q);
        if (L == null && R == null) {
            return root;
        }
        if (L == null) {
            return R;
        }
        return L;
    }
}