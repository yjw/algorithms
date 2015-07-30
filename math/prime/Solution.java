public class Solution {
    public int countPrimes(int n) {
        assert(n >= 0);
		boolean[] nPrime = new boolean[n];
        int count = 0;
		for (int i = 2; i < n; i++) {
            if (nPrime[i]) {
				continue;
			}
			for (int j = 2; i * j < n; j++) {
				nPrime[i * j] = true;
			}
        }

		for (int i = 2; i < n; i++) {
			if (!nPrime[i]) {
				count++;
			}
		}
		return count;
    }
}
