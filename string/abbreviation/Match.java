public class Match {
	public boolean isMatch(String str, String abbr) {
		int ps = 0, pa = 0, number = 0;
		while (ps < str.length() && pa < abbr.length()) {
			if (isDigit(abbr.charAt(pa) )!= -1) {
				number = number * 10 + isDigit(abbr.charAt(pa));
				pa++;				
			}
			else {
				ps += number;
				number = 0;
				if (ps >= str.length()) {
					return false;
				}
				if (str.charAt(ps) != abbr.charAt(pa)) {
					return false;
				}
				ps++;
				pa++;
			}
		}
		ps += number;
		return ps == str.length() && pa == abbr.length();
	}
	
	private int isDigit(char c) {
		if (c <= '9' && c >= '0') {
			return c - '0';
		}
		return -1;
	}
}