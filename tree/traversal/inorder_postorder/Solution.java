import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public ArrayList<Integer> inorder(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while (p != null || !stack.empty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            }
            else {
                p = stack.pop();
                res.add(p.val);
                p = p.right;
            }
        }
        return res;
    }
    
    public ArrayList<Integer> postorder(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode curr = stack.peek();
            if (prev == null || curr.left != null || curr.right != null) {
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
                res.add(curr.val);
                stack.pop();
            }
            prev = curr;
        }
        return res;
    }
    
}
