import java.util.List;
import java.util.ArrayList;

//第一种方法就是不保存，一列/行 一列的打
public class Vertical {
    private int[] left = {0};
    private int[] right = {0};
    //left[0] = {0}, right[0] = {0};
    public List<List<Integer>> traverse (TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        update_min_max(root, 0, left, right);
        for (int i = left[0]; i < right[0]; i ++) {
            List<Integer> item = new ArrayList<Integer>();
            print_vertical(root, 0, i, item);
            res.add(item);
        }
        return res;
    }
    
    private void update_min_max(TreeNode root, int hd, int[] left, int[] right) {
        if (root == null) {
            return;
        }
        if (hd < left[0]) {
            left[0] = hd;
        }
        else if (hd > right[0]) {
            right[0] = hd;
        }
        update_min_max(root.left, hd - 1, left, right);
        update_min_max(root.right, hd + 1, left, right);
    }
    
    private void print_vertical (TreeNode root, int hd, int vert, List<Integer> item) {
        if (root == null) {
            return;
        }
        if (hd == vert) {
            item.add(root.val);
        }
        print_vertical(root.left, hd - 1, vert, item);
        print_vertical(root.right, hd + 1, vert, item);
    }
}