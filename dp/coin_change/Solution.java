public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length < 1) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] == i) {
                    min = 1;
                    break;
                }
                if (i - coins[j] > 0 && dp[i - coins[j]] > 0) {
                    if (min > 1 + dp[i - coins[j]]) {
                        min = 1 + dp[i - coins[j]];
                    }
                }
            }
            if (min == Integer.MAX_VALUE) {
                dp[i] = -1;
            }
            else {
                dp[i] = min;
            }
        }
        return dp[amount];
    }
}