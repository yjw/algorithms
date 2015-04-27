public class Solution {
    public int gcd (int a, int b) {
        if (a < b) {
            int t = b;
            b = a;
            a = b;
            return gcd(a, b);
        }
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
