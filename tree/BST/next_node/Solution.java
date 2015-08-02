public class Solution {
    public TreeNodeP next (TreeNodeP node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return leftmost(node.right);
        }
        else {
            while (node.parent != null && node.parent.right == node) {
                node = node.parent;
            }
            return node.parent;
        }
    }
    
    private TreeNodeP leftmost(TreeNodeP node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}