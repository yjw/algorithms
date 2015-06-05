public class Solution {
	public int sum (int[][] matrix) {
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = matrix[i - 1][j] + matrix[i][j];
			}
		}
		
		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			int[] array = new int[matrix[0].length];
			for (int j = 0; j < matrix[0].length; j++) {
				array[j] = matrix[i][j];
			}
			int temp = 0;
			for (int j = 0; j < matrix[0].length; j++) {
				temp += array[j];
			}
			if (temp )
			for (int row = i; row > 0; row--) {
				for (int j = 0; j < matrix[0].length; j++) {
					temp += matrix[i][j];
					col_max = Math.max(col_max, temp);
					if (temp <= 0) {
						temp = 0;
					}
				
				}
			}
			max = Math.max(max, col_max);
		}
		return max;
	}
}