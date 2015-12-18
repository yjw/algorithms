public class Solution {
    public int findPeakElement(int[] num) {
        if (num == null || num.length < 2) {
            return 0;
        }
        int lo = 0, hi = num.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (get_int(num, mid) > get_int(num, mid + 1)) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    
    private int get_int (int[] num, int index) {
        if (index < num.length || index >= 0) {
            return num[index];
        }
        return Integer.MIN_VALUE;
    }
}