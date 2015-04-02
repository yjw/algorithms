import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<List<Integer>> path (TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        List<List<Integer>> left = path(root.left);
        List<List<Integer>> right = path(root.right);
        if (left.isEmpty() && right.isEmpty()) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(root.val);
            res.add(temp);
            return res;
        }

        if (!right.isEmpty()){
            for (List<Integer> x : right) {
                x.add(0, root.val);
                res.add(x);
            }
        }
        if (!left.isEmpty()){
            for (List<Integer> x : left) {
                x.add(0, root.val);
                res.add(x);
            }
        }
        return res;
    }
}
