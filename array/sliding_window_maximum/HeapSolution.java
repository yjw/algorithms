import java.util.PriorityQueue;
import java.util.Comparator;

public class HeapSolution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        assert(k <= nums.length);
        if (nums.length < 1) {
            return new int[0];
        }
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(new MyComparator());
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k - 1; i++) {
            queue.offer(new Pair(i, nums[i]));
        }
        for (int i = k - 1; i < nums.length; i++) {
            queue.offer(new Pair(i, nums[i]));
            while (queue.peek().index < i - k + 1) {
                queue.poll();
            }
            res[i - k + 1] = queue.peek().value;
        }
        return res;
    }
}


class Pair {
    int index;
    int value;
    Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }
}

class MyComparator implements Comparator<Pair> {
    public int compare(Pair o1, Pair o2) {
        if (o1.value < o2.value) {
            return 1;
        }
        if (o1.value > o2.value) {
            return -1;
        }
        return 0;
    }
}
