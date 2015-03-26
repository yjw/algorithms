public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null) {
            return p == null;
        }
        if (s.length() < 1) {
            return p.length() < 1 || p == "*";
        }
        return isMatch(s, 0, p, 0);
    }
    
    private boolean isMatch(String s, int sp, String p, int pp) {
        if (sp == s.length()) {
            return pp == p.length() || ((pp == p.length() -1) && p.charAt(pp) == '*');
        }
        if ( pp == p.length()) {
            return sp == s.length();
        }
        if (p.charAt(pp) != '*') {
            if (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?') {
                return isMatch(s, sp + 1, p, pp + 1);
            }
            return false;
        }
        else {
            for (int i = sp; i < s.length(); i++) {
                if (isMatch(s, i, p, pp + 1)) {
                    return true;
                }
            }
            return false;
        }
    }
}
