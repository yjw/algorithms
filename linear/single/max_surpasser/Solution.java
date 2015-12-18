public class Solution {
	public int surpasser(int[] array) {
		if (array == null || array.length < 1) {
			return 0;
		}
		int len = array.length;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int lo = 0, hi = len - 1;
		count(array, lo, hi, map);
	}
	private void count(int[] array, int lo, int hi, HashMap<Integer, Integer> map) {
		if (lo >= hi) {
			return;
		}
		int mid = lo + (hi - lo) / 2;
		count(array, lo, mid, map);
		count(array, mid + 1, hi, map);
		//int i = lo;
		int m = mid + 1;
		int[] temp = new int[hi - lo + 1];
		int first = 0, second = mid + 1 - lo;
		for (int i = lo; i <= hi; i++) {
			temp[i - lo] = array[i];
		}
		while (first < mid + 1 - lo && second <= hi - lo) {
			if (temp[first] <  temp[second]) {
				int c = hi - second + 1;
				if (map.containsKey(temp[first])) {
					map.put(temp[first], map.get(temp[first]) + 1);
				}
				else {
					map.put(array[first], c);
				}
				array[first]
			}
		}
	}
}