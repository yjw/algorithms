public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
		if (denominator == 0) {
			return null;
		}

		if (numerator == 0) {
			return "0";
		}
		int positive = 1;
		if (numerator < 0 && denominator > 0 || numerator > 0
				&& denominator < 0) {
			positive = -1;
		}
		long num = numerator;
		long den = denominator;
		num = Math.abs(num);
		den = Math.abs(den);
		long integ = num / den;
		long fraction = num % den;
		if (fraction == 0) {
			return Long.toString(positive * integ);
		}

		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		int location = 0;
		long curr = fraction * 10;
		StringBuilder sb = new StringBuilder();
		while (!map.containsKey(curr) && curr != 0) {
			
			//System.out.println("here");
			char c = (char) (curr / den + '0');
			System.out.println(curr / den);
			System.out.println("c is " + c);
			map.put(curr, location);
			location++;
			sb.append(c);
			if (c == '0') {
				curr *= 10;
			} else {
				curr = (curr % den) * 10;
			}
		}
		if (curr == 0) {
			if (positive == 1) {
				return Long.toString(integ) + "." + sb.toString();
			}
			return "-" + Long.toString(integ) + "." + sb.toString();
		}
		String str = sb.toString();
		int recur = map.get(curr);
		if (positive == 1) {
			return Long.toString(integ) + "." + str.substring(0, recur)
					+ "(" + str.substring(recur) + ")";
		}
		return "-" + Long.toString(integ) + "." + str.substring(0, recur)
				+ "(" + str.substring(recur) + ")";
	}
}
