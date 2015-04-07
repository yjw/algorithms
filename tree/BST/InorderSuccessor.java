public class InorderSuccessor {
    public TreeNode successor (TreeNode root, TreeNode node) {
        if (root == null || node == null) {
            return null;
        }
        if (node.right != null) {
            return min_node(node.right);
        }
        TreeNode succ = null;
        while (root != null) {
            if (node.val < root.val) {
                succ = root;
                root = root.left;
            }
            else if (node.val > root.val) {
                root = root.right;
            }
            else {
                break;
            }
        }
        return succ;
    }
    
    private TreeNode min_node (TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
