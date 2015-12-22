public class Solution {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int len = s.length();
        char[] sb = new char[len];
        int[] cnt = new int[26];
        boolean[] isRes = new boolean[26];
        int end = -1;
        for (int i = 0; i < len; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (isRes[c - 'a']) {
                cnt[c - 'a']--;
                continue;
            }
            while (end != -1 && sb[end] > c && cnt[sb[end] - 'a'] > 0) {
                isRes[sb[end] - 'a'] = false;
                end--;
            }
            sb[++end] = c;
            cnt[c - 'a']--;
            isRes[c - 'a'] = true;
        }
        return String.valueOf(sb).substring(0, end + 1);
    }
}