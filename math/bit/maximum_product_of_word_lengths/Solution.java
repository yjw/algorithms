public class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length < 2) {
            return 0;
        }
        int max = 0;
        int[] bits = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            bits[i] = tobits(words[i]);
            for (int j = 0; j < i; j++) {
                if ((bits[i] & bits[j]) == 0) {
                    int val = words[i].length() * words[j].length();
                    if (val > max) {
                        max = val;
                    }
                }
            }
        }
        return max;
    }
    private int tobits (String str) {
        int bits = 0, cursor = 1;
        for (int i = 0; i < str.length(); i++) {
            bits = bits | cursor << (str.charAt(i) - 'a');
        }
        return bits;
    }
}
