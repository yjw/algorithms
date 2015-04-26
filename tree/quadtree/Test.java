public class Test {
    public static void main (String[] args) {
        Solution s = new Solution();
        int[][] m = {{0, 1}, {1, 1}};
        int[][] n = {{0, 1}, {1, 1}};
        QuadTree t = new QuadTree();
        QuadNode p = t.build(m);
        QuadNode q = t.build(n);
        System.out.println(s.intersections(p, q));
    }
}