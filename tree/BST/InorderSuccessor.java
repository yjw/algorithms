public class InorderSuccessor {
    public TreeNode successor (TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.right != null) {
            return min_node(root.right);
        }
        
    }
    
    private TreeNode min_node (TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}