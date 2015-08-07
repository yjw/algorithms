package yset;

public class Solution {
	public String compress(String str) {
		if (str == null || str.length() < 1) {
			return str;
		}
		StringBuilder sb = new StringBuilder();
		char c = str.charAt(0);
		int count = 1, i = 1;
		while (i < str.length()) {
			if (str.charAt(i) == c) {
				count++;
			}
			else {
				sb.append(c);
				sb.append(count);
				c = str.charAt(i);
				count = 1;
			}
			i++;
		}
		sb.append(c);sb.append(count);
		String res = sb.toString();
		if (res.length() >= str.length()) {
			return str;
		}
		return res;
	}
}