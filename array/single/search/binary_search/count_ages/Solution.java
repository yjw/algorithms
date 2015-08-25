import java.util.HashMap;

public class Solution {
    public HashMap<Integer, Integer> count(int[] array) {
        int curr = array[0], i = 0, step = 1, count = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (i < array.length) {
            count += step;
            step *= 2;
            if (array[i + step] != curr) {
                step = 1;
            }
            if (i + step >= array.length || array[i + step] != curr) {
                map.put(curr, count);
                step = 1;            
                curr = array[i + step];
                i += step;
            }
        }
        return map;
    }
}