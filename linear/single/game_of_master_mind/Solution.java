public class Solution {
    public int[] calculate (String guess, String slots) {
        int[] hits = new int[2];
        // hits[0] is the number real hits;
        // hits[1] is the number pseudo hits.
        int pseudo = 0, hit = 0;
        int[] frequency = new int[4];
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == slots.charAt(i)) {
                hit++;
            }
            else {
                frequency[code(slots.charAt(i))]++;
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            int cc = code(guess.charAt(i));
            if (guess.charAt(i) != slots.charAt(i) && frequency[cc] > 0) {
                pseudo++;
                frequency[cc]--;
            }
        }
        hits[0] = hit;
        hits[1] = pseudo;
        return hits;
    }
    
    private int code (char c) {
        if (c == 'R') {
            return 0;
        }
        if (c == 'Y') {
            return 1;
        }
        if (c == 'G') {
            return 2;
        }
        else {
            return 3;
        }
    }
}