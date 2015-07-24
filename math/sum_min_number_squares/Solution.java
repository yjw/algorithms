package nonleetcode;

import java.util.ArrayList;

public class Solution {
	public ArrayList<Integer> minNum(int sum) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i <= sum; i++) {
			list.add(new ArrayList<Integer>());
		}

		list.get(1).add(1);
		list.get(2).add(1);
		list.get(2).add(1);
		int min = Integer.MAX_VALUE;
		for (int i = 3; i < sum; i++) {
			int p = 1;
			ArrayList<Integer> tem = new ArrayList<>();
			while (p * p <= i) {
				int left = i - p * p;
				if (list.get(left).size() + 1 < min) {
					min = list.get(left).size() + 1;
					tem = new ArrayList<Integer>(list.get(left));
					tem.add(p * p);
				}
				p++;

				list.get(i).addAll(tem);
			}
		}
		return list.get(sum);
	}
}