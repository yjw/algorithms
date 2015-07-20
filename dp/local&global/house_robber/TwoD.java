package ds;

public class TwoD {
	public int rob(int[] num) {
		int len = num.length;
		int[][] dp = new int[len + 1][2];
		for (int i = 1; i < len + 1; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
			dp[i][1] = dp[i - 1][0] + num[i - 1];
		}
		return Math.max(dp[len][0], dp[len][1]);
	}
}