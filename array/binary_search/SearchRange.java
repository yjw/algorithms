public class SearchRange {
    public int[] searchRange(int[] A, int target) {
        int[] a = new int[2];
        if (search_lo(A, target, 0, A.length - 1) == -1) {
            a[0] = -1;
            a[1] = -1;
            return a;
        }
        a[0] = search_lo(A, target, 0, A.length - 1);
        a[1] = search_hi(A, target, 0, A.length - 1);
        return a;
    }
    
    private int search_lo(int[] A, int target, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        int mid = (lo + hi) / 2;
        if (A[mid] == target && (mid == 0 || A[mid - 1] < target)) {
            return mid;
        }
        if (A[mid] < target) {
            return search_lo(A, target, mid + 1, hi);
        }
        else {
            return search_lo(A, target, lo, mid - 1);
        }
    }
    
    private int search_hi(int[] A, int target, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        int mid = (lo + hi) / 2;
        if (A[mid] == target && (mid == A.length - 1 || A[mid + 1] > target)) {
            return mid;
        }
        if (A[mid] <= target) {
            return search_hi(A, target, mid + 1, hi);
        }
        else {
            return search_hi(A, target, lo, mid - 1);
        }
    }
}
