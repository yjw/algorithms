class Range {
    int lo;
    int hi;
    boolean set;
    Range() {
        set = false;
        lo = Integer.MAX_VALUE;
        hi = Integer.MIN_VALUE;
    }
}

public class Solution {
    public int maximumGap(int[] num) {
        if (num == null || num.length < 2) {
            return 0;
        }
        // Get max and min
        int max = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < num.length; i++) {
            if (num[i] > max) {
                max = num[i];
            }
            if (num[i] < min) {
                min = num[i];
            }
        }
        Range[] ranges = new Range[num.length];
        for (int i = 0; i < ranges.length; i++) {
            ranges[i] = new Range();
        }
        double bucket_size = (double)(max - min)/(double)(num.length - 1);
        for (int i = 0; i < num.length; i++) {
            int location = (int)((num[i] - min) / bucket_size);
            Range curr = ranges[location];
            if (!curr.set) {
                curr.set = true;
                curr.lo = num[i];
                curr.hi = num[i];
            }
            if (num[i] < curr.lo) {
                curr.lo = num[i];
            }
            if (num[i] > curr.hi) {
                curr.hi = num[i];
            }
        }
        
        int first_non_empty = 0;
        while (!ranges[first_non_empty].set) {
            first_non_empty++;
        }
        max = ranges[first_non_empty].hi - ranges[first_non_empty].lo;
        Range prev = ranges[first_non_empty];
        for (int i = first_non_empty + 1; i < ranges.length; i++) {
            if (!ranges[i].set) {
                continue;
            }
            max = Math.max(max, Math.max(ranges[i].hi - ranges[i].lo, ranges[i].lo - prev.hi));
            prev = ranges[i];
        }
        return max;
    }
}