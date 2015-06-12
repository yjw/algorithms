public class Solution {
	public int max(int a,  int b) {
		int c = a - b;
		int sa = sign(a);
		int sb = sign(b);
		int sc = sign(c);
		
		int different_sign = sa ^ sb; //1: a, b different sign
		int same_sign = flip(sa ^ sb); // 1: a, b same sign
		int k = different_sign * sa + same_sign * sc;
		int q = flip(k);
		return a * k + b * q;
	}
	/*
	* Case 1: a and b are both positive or negative;
	*         get the sign of a - b as k; return k * a + q * b
	*         q is flip(k)
	* Case 2: a and b have different signs:
	*         use sign of a
	*     
	*         
	*/
	private int sign (int a) {
		return flip(a >> 31 & 1);
	}
	
	private int flip (int bit) {
		return 1^bit;
	}
	
}