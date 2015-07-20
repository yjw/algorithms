public class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len < 1) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        return Math.max(helper(nums, 0, len - 2), helper(nums, 1, len - 1));
    }
    
    
    private int helper(int[] num, int lo, int hi) {
        int py = 0, pn = 0;
        for (int i = lo; i <= hi; i++) {
            int temp = pn;
            pn = Math.max(py, pn);
            py = temp + num[i];
        }
        
        return Math.max(py, pn);
    }
    
}