public int  count(Node root) {
    int  m, n;
    if (root.cover == 1) {
        return root.right - root.left;
    }
    else if (root.right - root.left== 1 ) {
        return 0;
    }
    m = count(root.left);
    n = count(root.right);
    return m + n;
}