public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int get_from_nums1 = Math.min(nums1.length, k);
        int[] ans = new int[k];
        for (int i = Math.max(k - nums2.length, 0); i <= get_from_nums1; i++) {
            int[] res1 = new int[i];
            if (i > 0)
                res1 = solve(nums1, i);
            int[] res2 = new int[k - i];
            if (k - i > 0)
                res2 = solve(nums2, k - i);
            int pos1 = 0, pos2 = 0, tpos = 0;
            int[] res = new int[k];
            while (res1.length > 0 && res2.length > 0 && pos1 < res1.length && pos2 < res2.length) {
                if (res1[pos1] > res2[pos2])
                    res[tpos++] = res1[pos1++];
                else if (res1[pos1] < res2[pos2])
                    res[tpos++] = res2[pos2++];
                else {
                    int x = pos1;
                    int y = pos2;
                    while (x < res1.length && y < res2.length && res1[x] == res2[y]) {
                        x++;
                        y++;
                    }
                    if (x < res1.length && y < res2.length) {
                        if (res1[x] < res2[y]) {
                            res[tpos++] = res2[pos2++];
                        } else {
                            res[tpos++] = res1[pos1++];
                        }
                    } else if (x < res1.length) {
                        res[tpos++] = res1[pos1++];
                    } else {
                        res[tpos++] = res2[pos2++];
                    }
                }
            }
            while (pos1 < res1.length)
                res[tpos++] = res1[pos1++];
            while (pos2 < res2.length)
                res[tpos++] = res2[pos2++];

            if (updateAns(ans, res))
                ans = res;
        }
        return ans;
    }

    public boolean updateAns(int[] ans, int[] res) {
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] > res[i])
                return false;
            if (ans[i] < res[i])
                return true;
        }
        return false;
    }

    public int[] solve(int[] nums, int k) {
        int[] res = new int[k];
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            while (len > 0 && len + nums.length - i > k && res[len - 1] < nums[i]) {
                len--;
            }
            if (len < k)
                res[len++] = nums[i];
        }
        return res;
    }
}