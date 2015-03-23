import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class Post {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) {
            return result;
        }
        stack.push(root);
        TreeNode prev = null;
        while(!stack.empty()) {
            TreeNode curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null) {
                    stack.push(curr.left);
                }
                else if (curr.right != null) {
                    stack.push(curr.right);
                }
            }
            else if (curr.left == prev) {
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            }
            else {
                result.add(curr.val);
                stack.pop();
            }
            prev = curr;
        }
        return result;
    }
}