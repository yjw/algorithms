public class Test {
	public static void main (String[] args) {
		Solution s = new Solution();
		int[] array = {1, 2, 8, 9, 3, 5, 12, 4, 0, -2, -5, 100};
		s.wiggleSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(" " + array[i]);
		}
	}
}