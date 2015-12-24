import java.util.HashMap;

public class Solution {
    public int[] shortest(int[] array, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        long sum = 0;
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            map.put(sum, i);
        }
        sum = 0;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(target + sum)) {
                int end = map.get(target + sum);
                int begin = i;
                if (end - begin < diff) {
                    diff = end - begin;
                    res[0] = begin;
                    res[1] = end;
                }
            }
            sum += array[i];
        }
        return res;
    }
}