package ds;

public class OneD {
	public int rob(int[] num) {
		int len = num.length;
		if (len < 1) {
			return 0;
		}
		if (len == 1) {
			return num[0];
		}
		int[] dp = new int[len + 1];
		dp[1] = num[0];
		dp[2] = num[1];
		for (int i = 3; i < len + 1; i++) {
			dp[i] = Math.max(dp[i - 2], dp[i - 3]) + num[i - 1];
		}
		return Math.max(dp[len], dp[len - 1]);
	}
}