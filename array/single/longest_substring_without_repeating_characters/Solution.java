/*
Given a string, find the length of the longest substring without
repeating characters. For example, the longest substring without 
repeating letters for "abcabcbb" is "abc", which the length is 3.
For "bbbbb" the longest substring is "b", with the length of 1.
*/

/*
The key to do it successfully is to update the start correctly!!! 
*/

public class Solution {
    public int _lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int len = s.length();
        if (len == 1) {
            return len;
        }
        boolean[] map = new boolean[128];
        int max = 0, start = 0;
        for (int i = 0; i < len; i++) {
            int index = (int)s.charAt(i);
            if (map[index]) {
                int p = start;
                while (s.charAt(p) != s.charAt(i)) {
                    map[(int)s.charAt(p)] = false;
                    p++;
                }
                max = Math.max(max, i - start);
                start = p + 1;
                
            }
            else {
                map[index] = true;
            }
        }
        max = Math.max(max, len - start);
        return max;
    }
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int len = s.length();
        if (len == 1) {
            return len;
        }
        int[] array = new int[128];
        int start = 1, max = 0;
        for (int i = 1; i <= len; i++) {
            int index = (int) s.charAt(i - 1);
            if (array[index] != 0) {
                max = Math.max(max, i - start);
                start = Math.max(array[index] + 1, start);
            }
            array[index] = i;
        }
        max = Math.max(max, len - start + 1);
        return max;
    }
}
