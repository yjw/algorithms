public class TwoV {
	public int rob(int[] num) {
		int len = num.length;
		if (len < 1) {
			return 0;
		}
		if (len == 1) {
			return num[0];
		}
		int py = 0, pn = 0;
		
		for (int i = 0; i < len; i++) {
			int temp = pn;
			pn = Math.max(py, pn);
			py = temp + num[i];
		}
		return Math.max(py, pn);
	}
}