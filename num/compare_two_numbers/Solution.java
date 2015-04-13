public class Solution {
    public int getMax(int a, int b) {
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(a - b);
        //哪些情况用a的符号？
        int different = sa ^ sb;
        int use_sign_of_c = flip(sa ^ sb);
        int k = different * sa + use_sign_of_c * sc;
        int q = flip(k);
        return a * k + b * q;
    }
    
    // 1 is positive; 2 is negative
    private int sign (int a) {
        return flip (a >> 31 & 1);
    }
    
    private int flip (int bit) {
        return bit ^ 1;
    }
}