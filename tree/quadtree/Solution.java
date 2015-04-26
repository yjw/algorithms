public class Solution {
    //private int ret;
    public int intersections (QuadNode p, QuadNode q) {
        if (p == null || q == null || p.ones == 0 || q.ones == 0) {
            return 0;
        }
        return intersections(p, q);       
    }
    private int intersect (QuadNode p, QuadNode q) {
        if (p.child[0] == null) {
            if (p.ones == 1 && q.ones == 1) {
                return 1;
            }
            else {
                return 0;
            }
        }
        int ret = 0;
        for (int i = 0; i < 4; i++) {
            if (p.child[i].ones == 0 || q.ones == 0) {
                continue;
            }
            ret += intersect(p.child[i], q.child[i]);
        }
        return ret;
    }
}