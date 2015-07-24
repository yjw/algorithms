public class SolutionI {
    public boolean isMatch(String str, String pattern) {
        int s = 0, p = 0, star = -1, match = 0;
        while (s < str.length()) {
            if (p < pattern.length() && (str.charAt(s) == pattern.charAt(p) || pattern.charAt(p) == '?')) {
                s++;
                p++;
            }
            else if (p < pattern.length() && pattern.charAt(p) == '*') {
                star = p;
                p++;
                match = s;
            }
            else if (star != -1) {
                p = star + 1;
                match++;
                s = match;
            }
            else {
                return false;
            }
        }
        while (p < pattern.length() && pattern.charAt(p) == '*') {
            p++;
        }
        return p == pattern.length();
    }
}
