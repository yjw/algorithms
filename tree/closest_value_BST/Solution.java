public class Solution {
    public TreeNode closest (TreeNode root, int target) {
        if (root == null) {
            return root;
        }
        if (target.val < root.val) {
            if (root.left == null) {
                return root;
            }
            TreeNode p = closest(root.left, target);
            if ()
        }
    }
}
