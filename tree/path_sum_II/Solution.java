import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new LinkedList<Integer>();
        Stack<TreeNode> rights = new Stack<TreeNode>();
        Stack<Integer> steps = new Stack<Integer>();
        int psum = 0;
        int step = 0;
        
        while(root != null) {
            path.add(root.val);
            psum += root.val;
            // Save result if found
            if (root.left == null && root.right == null && psum == sum) {
                result.add(new LinkedList<Integer>(path));
            }
            // Stack right children and back steps
            // to next stacked right children
            if (root.right != null) {
                rights.push(root.right);
                steps.push(step);
                step = 0;
            }
            
            // Get TreeNode for next iteration
            root = root.left;
            if (root == null && !rights.isEmpty()) {
                root = rights.pop();
                for (int i=0; i<step; i++) {
                    int last = path.removeLast();
                    psum -= last;
                }
                step = steps.pop();
            }
            // We have to remeber steps we did after last
            // right children pushed to stack
            step++;
        }
        return result;
    }
}