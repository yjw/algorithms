public class Solution {
	public int game (int[] coins) {
		int len = coins.length;
		int[][] dp = new int[len][len];
		for (int i = 0; i < len; i++) {
			dp[i][i] = coins[i];
		}
		for (int i = len - 2; i >= 0; i--) {
			for (int j = i + 1; j < len; j++) {
				if (j - i == 1) {
					dp[i][j] = Math.max(coins[i], coins[j]);
				}
				else {
					dp[i][j] = Math.max(coins[i] + Math.min(dp[i + 1][j - 1], dp[i + 2][j]), coins[j] + Math.min(dp[i][j - 2], dp[i + 1][j - 1]));
				}
			}
		}
		return dp[0][len - 1];
	}
}