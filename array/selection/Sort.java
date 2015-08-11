import java.util.Arrays;

public class Sort {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        if (k >= len) {
            return -1;
        }
        Arrays.sort(nums);
        return nums[len - k];
    }
}