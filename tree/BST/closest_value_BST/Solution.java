public class Solution {
    public TreeNode closest (TreeNode root, int target) {
        if (root == null) {
            return root;
        }
        if (root.val == target) {
            return root;
        }
        if (target < root.val) {
            if (root.left == null) {
                return root;
            }
            TreeNode p = closest(root.left, target);
            return Math.abs(p.val - target) > Math.abs(root.val - target) ? root : p;
        }
        else {
            if (root.right == null) {
                return root;
            }
            TreeNode p = closest(root.right, target);
            return Math.abs(p.val - target) > Math.abs(root.val - target) ? root : p;
        }
    }
}
