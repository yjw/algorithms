import java.util.Random;

public class ReservoirSampling {
	public int[] sample (int[] nums, int k) {
		int[] res = new int[k];
		Random rand = new Random();
		for (int i = 0; i < k; i++) {
			res[i] = nums[i];
		}
		for (int i = k; i < nums.length; i++) {
			int r = rand.nextInt(i + 1);
			if (r < k) {
				res[i] = nums[i];
			}
		}
		return res;
	}
}