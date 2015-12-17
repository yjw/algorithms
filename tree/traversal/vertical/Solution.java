import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;

public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> order = new LinkedList<Integer>();
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        order.offer(0);
        queue.offer(root);
        int min = 0, max = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int col = order.poll();
            if (node.left != null) {
                queue.offer(node.left);
                order.offer(col - 1);
                if (col - 1 < min) {
                    min = col - 1;
                }
            }
            if (node.right != null) {
                queue.offer(node.right);
                order.offer(col + 1);
                if (col + 1 > max) {
                    max = col + 1;
                }
            }
            if (map.containsKey(col)) {
                map.get(col).add(node.val);
            }
            else {
                List<Integer> item = new ArrayList<Integer>();
                item.add(node.val);
                map.put(col, item);
            }
        }
        for (int i = min; i <= max; i++) {
            if (map.containsKey(i)) {
                res.add(map.get(i));
            }
        }
        return res;
    }
}
