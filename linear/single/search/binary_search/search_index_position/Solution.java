public class Solution {
    public int searchInsert(int[] A, int target) {
        int lo = 0;
        int hi = A.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[mid] < target) {
                lo = mid + 1;
            }
            else {
                hi = mid;
            }
        }
        return A[lo] < target? lo + 1:lo;
    }
}