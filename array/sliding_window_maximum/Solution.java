import java.util.Deque;
import java.util.LinkedList;

public class Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {
		Deque<Integer> deque = new LinkedList<Integer>();
		int len = nums.length;
		if (len < 1) {
		    return new int[0];
		}
		int[] res = new int[len - k + 1];
		for (int i = 0; i < len; i++) {
			while (!deque.isEmpty() && nums[deque.getLast()] < nums[i] ) {
				deque.removeLast();
			}
			deque.offer(i);
			while (deque.peek() < i - k + 1) {
				deque.poll();
			}
			//System.out.println(deque);
			if (i >= k - 1) {
				res[i - k + 1] = nums[deque.peek()];
			}
		}
		return res;
	}
}