//This requires O(n) space and O(mn^2) time.

public class Solution {
	public int maximalSquare (char[][] matrix) {
		if (matrix.length < 1 || matrix[0].length < 1) {
			return 0;
		}
		int row = matrix.length, col = matrix[0].length;
		int[] dp = new int[col];
		int max = 0;
		for(int i = 0; i < col; i++) {
			if (matrix[0][i] == '1') {
				dp[i] = 1;
				max = 1;
			}
		}
		for (int i = 1; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == '0') {
					dp[j] = 0;
					continue;
				}
				else {
					dp[j]++;
					int curr = j, step = 0, min = dp[curr];
                    while (curr - step >= 0 && step < dp[j]) {
                        min = Math.min (dp[curr - step], min);
                        max = Math.max (max, Math.min(min, step + 1));
                        step++;
                    }
				}
			}
		}
		return max * max;
	}
}
