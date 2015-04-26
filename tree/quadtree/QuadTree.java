public class QuadTree {
    public QuadNode build (int[][] mat) {
        if (mat == null || mat.length < 1) {
            return null;
        }
        return build(mat, 0, 0, mat.length);
    }
    
    private QuadNode build (int[][] mat, int row, int col, int size) {
        if (size == 1) {
            QuadNode node = new QuadNode();
            node.ones = mat[row][col];
            return node;
        }
        size = size / 2;
        QuadNode root = new QuadNode();
        root.child[0] = build(mat, row, col, size);
        root.child[1] = build(mat, row + size, col, size);
        root.child[2] = build(mat, row, col + size, size);
        root.child[3] = build(mat, row + size, col + size, size);
        for (int i = 0; i < 4; i++) {
            root.ones += root.child[i].ones;
        }
        return root;
    }
}