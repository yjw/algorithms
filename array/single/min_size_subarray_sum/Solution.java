public class Solution {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length < 1) {
			return 0;
		}
		int start = 0, sum = 0, end = 0, min = Integer.MAX_VALUE;
		while (end < nums.length) {
			sum += nums[end];
			while (sum >= s && start < nums.length) {
				sum -= nums[start];
				start++;
				min = Math.min(min, end - start + 2);
			}
			end++;
		}
		if (start == 0) {
		    return 0;
		}
		
		min = Math.min(min, end - start + 2);
		return min;
	}
}