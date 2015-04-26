public class Solution {
    public int[] wiggle (int[] s) {
        if (s == null || s.length < 3) {
            return s;
        }
        boolean flag = true;
        int current = s[0];
        for (int i = 0; i < s.length - 1; i++) {
            if ((flag && current > s[i + 1]) && (!flag && current < s[i + 1])) {
                s[i] = s[i + 1];
            }
            else {
                s[i] = current;
                current = s[i + 1];
            }
            flag = !flag;
        }
        s[s.length - 1] = current;
        return s;
    }
}