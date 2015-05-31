public class Solution {
	// This method is dynamic programming
	public int rmq_dp (int[] array, int m, int n) {
		int len = array.length;
		int[][] dp = new int[len][len];
		for (int i = 0; i < len; i++) {
			dp[i][i] = array[i];
		}
		for (int i = len - 2; i >= 0; i--) {
			for (int j = i + 1; j < len; j++) {
				dp[i][j] = Math.min(dp[i][j - 1], array[j]);
			}
		}
		return dp[m][n];
	}
	
	// This is Sqrt method
	public int rmq_sqrt (int[] array, int m, int n) {
		int len = array.length;
		int sq = (int)Math.sqrt((double)len);
		int num = len / sq + len % sq;
		int[] dp = new int[num];
		for (int i = 0; i < len / sq; i++) {
			int min = array[i * sq];
			dp[i] = i * sq;
			for (int j = i * sq; j < i * sq + sq; j++) {
				if (array[j] < array[i]) {
					dp[i] = j;
					min = array[j];
				}
			}
		}
		for (int i = len / sq; i < num; i++) {
			dp[i] = i * sq + i % sq;
		}
		int min = Integer.MAX_VALUE;
		if (m % sq != 0) {
			for (int i = m ; i < (m / sq + 1) * sq; i++) {
				if (array[i] < min) {
					min = array[i];
				}
			}
			m = (m / sq + 1) * sq;
		}
		if (n % sq != 0) {
			for (int i = (n / sq) * sq; i < n; i++) {
				if (array[i] < min) {
					min = array[i];
				}
			}
		}
		for (int i = m / sq; i < n / sq; i++) {
			if (array[dp[i]] < min) {
				min = array[dp[i]];
			}
		}
		return min;
	}
	
	// rmq sparse table log
	public int rmq_sparse_table(int[] array, int lo, int hi) {
		int n = array.length;
		int[] log = new int[n + 1];
		for (int i = 2; i <= n; i++) {
			log[i] = log[i >> 1] + 1;
		}
		int[][] dp = new int[log[n] + 1][n];
		for (int i = 0; i < n; i++) {
			dp[0][i] = i;
		}
		for (int k = 1; (1 << k) < n; k++) {
			for (int i = 0; i + (1 << k) <= n; i++) {
				int x = dp[k - 1][i];
				int y = dp[k - 1][i + (1 << k - 1)];
				dp[k][i] = array[x] <= array[y]? x : y;
			}
		}
		int step = log[hi - lo];
		int x = dp[step][lo];
		int y = dp[step][hi - (1 << step) + 1];
		return array[x] <= array[y] ? x : y;
	}
}