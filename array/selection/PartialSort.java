import java.util.PriorityQueue;

public class PartialSort {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        if (k > len) {
            return -1;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (count < k) {
                heap.offer(nums[i]);
                count++;
            }
            else {
                if (heap.peek() < nums[i]) {
                    heap.poll();
                    heap.offer(nums[i]);
                }
            }
        }
        return heap.poll();
    }
}