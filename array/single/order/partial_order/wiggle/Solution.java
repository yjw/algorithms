public class Solution {
	public void wiggleSort (int[] array) {
		boolean flag = true;
		if (array[0] > array[1]) {
			int temp = array[0];
			array[0] = array[1];
			array[1] = temp;
		}
		int pp = array[0];
		int p = array[1];
		for (int i = 2; i < array.length; i++) {
			if (flag && array[i] > array[i - 1] || !flag && array[i] < array[i - 1]) {
				int temp = array[i];
				array[i] = array[i - 1];
				array[i - 1] = temp;
			}
			flag = !flag;
		}
	}
}