import java.util.List;
import java.util.ArrayList;

public class Solution {
	public List<Integer> get_sequence (int[] array) {
		List<Integer> res = new ArrayList<Integer>();
		int len = array.length;		
		int[] min = new int[len];
		int[] max = new int[len];
		int m = 0;
		for (int i = 1; i < len; i++) {
			if (array[i] < array[m]) {
				m = i;
			}
			min[i] = m;
		}
		m = len - 1;
		max[m] = m;
		for (int i = len - 2; i >= 0; i--) {
			if (array[i] > array[m]) {
				m = i;
			}
			max[i] = m;
		}
		for (int i = 0; i < len; i++) {
			System.out.print(" " + min[i]);
		}
		for (int i = 0; i < len; i++) {
			System.out.print(" " + max[i]);
		}
		for (int i = 1; i < len - 1 ; i++) {
			if (array[i] > min[i] && array[i] < max[i]) {
				res.add(min[i]);
				res.add(i);
				res.add(max[i]);
				res.add(-1);
			} 
		}
		return res;
	}
}