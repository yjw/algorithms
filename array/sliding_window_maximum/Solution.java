import java.util.PriorityQueue;

public class Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {
		assert(k >= 1 && k <= nums.length);
	    PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
            if (max < nums[i]) {
                    max = nums[i];
            }
        }
	}
}
