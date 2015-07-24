import java.util.HashSet;

public class Solution {
    public boolean isHappy(int n) {
        if (n < 1) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        while (!set.contains(n)) {
            int s = 0;
            set.add(n);
            while (n != 0) {
                s = (n % 10) * (n % 10);
                n = n / 10;
            }
            n = s;
            if (n == 1) {
                return true;
            }
        }
        return false;
    }
}