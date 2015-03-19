import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode p;
    public BSTIterator(TreeNode root) {
        p = root;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode ret;
        p = stack.pop();
        ret = p;
        if (p.right != null) {
            p = p.right;
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
        }
        return ret.val;
    }
}
