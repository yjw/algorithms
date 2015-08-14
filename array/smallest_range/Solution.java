import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public int get_smallest_range(List<Integer>[] lists) {
        int range = 0;
        int k = lists.length;
        int max = Integer.MIN_VALUE;
        if (k == 0) {
            return range;
        }
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(new Cmp());
        for (List<Integer> x : lists) {
            Iterator<Integer> i = x.iterator();
            Pair p = new Pair(i.next(), i);
            queue.add(p);
            if (p.value > max) {
                max = p.value;
            }
        }
        while (true) {
            Pair top = queue.poll();
            if (!top.iter.hasNext()) {
                if (max - top.value > range) {
                    range = max - top.value;
                }
                return range;
            }
            top.value = top.iter.next();
            if (top.value > max) {
                max = top.value;
            }
            queue.offer(top);
        }
    }
}

class Pair {
    int value;
    Iterator<Integer> iter;
    Pair(int val, Iterator<Integer> i) {
        value = val;
        iter = i;
    }
}

class Cmp implements Comparator<Pair> {
    
    @Override
    public int compare(Pair p1, Pair p2) {
        if (p1.value > p2.value) {
            return 1;
        }
        if (p1.value < p2.value) {
            return -1;
        }
        return 0;
    }
}