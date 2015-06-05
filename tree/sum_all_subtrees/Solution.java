import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Solution {
	public HashMap<Integer, Integer> sum (HashMap<Integer, Integer> node, HashMap<Integer, Integer> val) {
		Set<Integer> set = new HashSet(val.keySet());
		HashSet<Integer> r = new HashSet<Integer>();
		for (int x : set) {
			if (r.contains(x)) {
				continue;
			}
			int value = 0;
			int p = node.get(x);
			while (p != -1) {
				if (!r.contains(x)) {
					value += val.get(x);
					r.add(x);
				}
				val.put(p, val.get(p) + value);
				x = p;
				p = node.get(p);
			}
		}
		return val;
	}
}