public class Balanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = check(root.left), right = check(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return false;
        }
        return true;
    }
    
    private int check (TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = check(root.left);
        int right = check(root.right);
        if (left == -1 || right == -1) {
            return -1;
        }
        if (left - right > 1 || left - right < -1) {
            return -1;
        }
        return Math.max(left, right);
    }
}