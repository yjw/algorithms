public class Test {
    public static void main (String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        t6.left = t2;
        t6.right = t7;
        t7.right = t9;
        t9.left = t8;
        t2.left = t1;
        t2.right = t4;
        t4.left = t3;
        t4.right = t5;
        // t6 is the root;
        Solution s = new Solution();
        System.out.println(s.path(t6));
    }
}
