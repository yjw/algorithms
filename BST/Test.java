public class Test {
    public static void main (String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);
        TreeNode i = new TreeNode(9);
        f.left = b;
        f.right = g;
        
        g.right = i;
        i.left = h;
        b.left = a;
        b.right = d;
        d.left = c; d.right = e;

        BSTIterator bb = new BSTIterator(f);
        while(bb.hasNext()) {
            System.out.println(bb.next());
        }
    }
}
