public class Solution {
    public TreeNode deepest (TreeNode root) {
        if (root == null || root.left == null) {
            return null;
        }
        int level = 1;
        TreeNode dpst = null;
        int max = 0;
        helper(root, false, 1, max, dpst);
        return dpst;
    }
    
    private void helper(TreeNode root, boolean isLeft, int level, int max, TreeNode dpst) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && level > max && isLeft) {
            dpst = root;
            max = level;
            return;
        }
        helper(root.left, true, level + 1, max, dpst);
        helper(root.right, false, level + 1, max, dpst);
    }
}
