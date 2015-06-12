public class Node {
    int lo;
    int hi;
    int cover;
    Node left;
    Node right;
    Node (int lo, int hi) {
        this.lo = lo;
        this.hi = hi;
        cover = 0;
    }
}