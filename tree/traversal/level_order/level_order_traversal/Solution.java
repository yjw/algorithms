import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder (TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int current_level = 1, next_level = 0;
        List<Integer> partial = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            current_level--;
            partial.add(temp.val);
            if (temp.left != null) {
                queue.offer(temp.left);
                next_level++;
            }
            if (temp.right != null) {
                queue.offer(temp.right);
                next_level++;
            }
            if (current_level == 0) {
                List<Integer> item = new ArrayList<Integer>(partial);
                res.add(item);
                current_level = next_level;
                next_level = 0;
                partial.clear();
            }
        }
        return res;
    }
}