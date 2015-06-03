public class Solution {
	public int longest (int[][] matrix) {
		int row = matrix.length, col = matrix[0].length;
		int[][] dp = new int[row][col];
		int max = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (dp[i][j] > 0) {
					max = Math.max(max, dp[i][j]);
					continue;
				}
				dp[i][j] = helper(matrix, dp, i, j);
				max = Math.max(max, dp[i][j]);
			}
		}
		/*
		for (int i = 0; i < row; i++) {
			System.out.println();
			for (int j = 0; j < col; j++) {
				System.out.print(" " + dp[i][j]);
			}
		}
		*/
		return max;
	}
	
	private int helper(int[][] matrix, int[][] dp, int m, int n) {
		if (m < 0 || n < 0 || m >= matrix.length || n >= matrix[0].length) {
			return -1;
		}
		if (dp[m][n] > 0) {
			return dp[m][n];
		}
		int max = 1;
		if (m - 1 >= 0 && matrix[m - 1][n] > matrix[m][n]) {
			max = Math.max(max, helper(matrix, dp, m - 1, n) + 1);
		}
		if (n - 1 >= 0 && matrix[m][n - 1] > matrix[m][n]) {
			max = Math.max(max, helper(matrix, dp, m, n - 1) + 1);
		}
		if (m + 1 < matrix.length && matrix[m + 1][n] > matrix[m][n]) {
			max = Math.max(max, helper(matrix, dp, m + 1, n) + 1);
		}
		if (n + 1 < matrix[0].length && matrix[m][n + 1] > matrix[m][n]) {
			max = Math.max(max, helper(matrix, dp, m, n + 1) + 1);
		}
		dp[m][n] = max;
		return max;
	}
}