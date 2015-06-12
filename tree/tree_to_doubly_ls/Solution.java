public class Solution {
    // It is not complete yet.
    public NodePair connect (TreeNode root) {
        if (root == null) {
            return null;
        }
        NodePair part1 = connect(root.left);
        NodePair part2 = connect(root.right);
        if (part1 != null) {
            part1.tail.left = root;
            root.right = part1.tail;
        }
        if (part2 != null) {
            part2.head.right = root;
            root.left = part2.head;
        }
        return new NodePair(part1 == null ? root : part1.head, part2 == null ? root : part2.tail);
    }
    
    private TreeNode convert_circular (TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode part1 = convert_circular(root.left);
        TreeNode part3 = convert_circular(root.right);
        if (part1 == null && part3 == null) {
            root.left = root;
            root.right = root;
            return root;
        }
        if (part1 == null) {
            part3.left.left = root;
            root.right = part3.left;
        }
        else {
            part1.left.left = root;
            root.right = part1.left;
        }
        if (part3 == null) {
            root.right = part1.left;
            part1.left.left = root; 
        }
    }
    
}

class NodePair {
    public TreeNode head;
    public TreeNode tail;
    
    NodePair(TreeNode head, TreeNode tail) {
        this.head = head;
        this.tail = tail;
    }
}