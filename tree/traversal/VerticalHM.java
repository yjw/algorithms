import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;

public class VerticalHM {
    public List<List<Integer>> traverse (TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        TreeMap<Integer, ArrayList<TreeNode>> map = new TreeMap<Integer, ArrayList<TreeNode>>();
        if (root == null) {
            return res;
        }
        add_to_map(root, 0, map);
        for (int i = map.firstKey(); i <= map.lastKey(); i++) {
            if (map.containsKey(i)) {
                ArrayList<TreeNode> temp = map.get(i);
                ArrayList<Integer> vals = new ArrayList<Integer>();
                for (TreeNode x : temp) {
                    vals.add(x.val);
                }
                res.add(vals);
            }
            
        }
        return res;
    }
    
    private void add_to_map (TreeNode root, int vert, TreeMap<Integer, ArrayList<TreeNode>> map) {
        if (root == null) {
            return;
        }
        if (map.containsKey(vert)) {
            map.get(vert).add(root);
        }
        else {
            ArrayList<TreeNode> item = new ArrayList<TreeNode>();
            item.add(root);
            map.put(vert, item);
        }
        add_to_map(root.left, vert - 1, map);
        add_to_map(root.right, vert + 1, map);
    }
}