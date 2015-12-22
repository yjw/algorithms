import java.util.HashSet;

public class Bruteforce {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int len = s.length();
        boolean[] isLast = new boolean[len];
        HashSet<Character> set = new HashSet<Character>();
        for (int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                continue;
            }
            set.add(c);
            isLast[i] = true;
        }
        set.clear();
        StringBuilder sb = new StringBuilder();
        char minc = 'z' + 1;
        int mini = 0;
        int curr = 0;
        while (curr < len) {
            char c = s.charAt(curr);
            if (set.contains(c)) {
                curr++;
                continue;
            }
            if (c < minc) {
                minc = c;
                mini = curr;
            }
            if (isLast[curr]) {
                sb.append(minc);
                set.add(minc);
                minc = 'z' + 1;
                curr = mini;
            }
            curr++;
        }
        return sb.toString();
    }
}