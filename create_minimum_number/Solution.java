/*
Obviously, it is a dynamic programming problem.
case 1: 
*/

public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][][] map = new int[len1][len2][k];
        int[] res = new int[k];

        for (int i = 0; i < k; k++) {
            for (int m = len1 - 1; m >= 0; m--) {
                for (int n = len2 - 1; n >= 0; n--) {
                    if (k > 0) {
                        int max = Math.max(nums1[m], nums2[n]);
                        map[m][n][k] = Math.max()
                    }
                }
            }
        }
    }

    private int get(int[] nums1, int[] nums2, int d) {
        if (d == 0) {
            return Integer.MIN_VALUE;
        }
        if (d > 0) {
            return nums1[d];
        }
        else {
            return nums2[d * (-1)];
        }
    }
}