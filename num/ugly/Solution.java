public class Solution {
	public int ugly (int n) {
		int n3 = 3, i3 = 0, n2 = 0, i2 = 2, n5 = 0, i5 = 1;
		int[] ugly = new int[n];
		ugly[0] = 1;
		for (int i = 1; i < n; i++) {
			int ret = Math.min(Math.min(n2, n3), n5);
			ugly[i] = ret;
			if (ret == n2) {
				n2 = ugly[++i2] * 2;
			}
			if (ret == n3) {
				n3 = ugly[++i3] * 3;
			}
			if (ret == n5) {
				n5 = ugly[++i5] * 5;
			}
		}
		return ugly[n - 1];
	}
}