public class Solution {
    public int adjust (int[] array, int target) {
        // 100 is the constant
        int[][] dp = new int[array.length][100];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < 100; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
    }
}
