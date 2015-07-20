public class ThreeV {
	public int rob(int[] num) {
		int len = num.length;
		if (len < 1) {
			return 0;
		}
		if (len == 1) {
			return num[0];
		}
		int b3 = 0, b2 = num[0], b1 = num[1];
		
		for (int i = 2; i < len; i++) {
			int temp = Math.max(b3, b2) + num[i];
			b3 = b2;
			b2 = b1;
			b1 = temp;
		}
		return Math.max(b1, b2);
	}
}