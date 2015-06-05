public class Test {
	public static void main (String[] args) {
		Solution s = new Solution();
		int[] a ={3, 0, 1, 0};
		int[] t = s.solve(a);
		for (int i = 0; i < t.length; i++) {
			System.out.print("  " + t[i]);
		}
	}
}