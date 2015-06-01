public class Node {
    int left;
    int right;
    int cover;
    Node left;
    Node right;
    Node (int left, int right) {
        this.left = left;
        this.right = right;
        cover = 0;
    }
}