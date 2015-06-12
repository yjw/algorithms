public class Solution {
    public String getShortestPalindrome(String word) {
        if (word == null || word.equals("")) {
            return word;
        }
        
        int n = word.length();
        int left = 0;
        int right = n - 1;
        boolean previousCharWasMismatch = false;
        StringBuilder appendOnRight = new StringBuilder(n);
        StringBuilder matchedOnRight = new StringBuilder(n);
        
        while (left < right) {
            char leftChar = word.charAt(left);
            char rightChar = word.charAt(right);
            
            if (leftChar == rightChar) {
                matchedOnRight.append(leftChar);
                ++left;
                --right;
                c = false;
            }
            else {
                appendOnRight.append(matchedOnRight);
                matchedOnRight.setLength(0);
                right = n - 1;
                /*
                if (previousCharWasMismatch) {
                    appendOnRight.append(leftChar);
                    ++left;
                }
                previousCharWasMismatch = true;
                */
            }
        }
        
        String shortestPalindrome = word + appendOnRight.reverse();
        return shortestPalindrome;
        
    }
}