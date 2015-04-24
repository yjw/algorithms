import java.util.HashMap;

public class Solution {
    public HashMap<Integer, Integer> count(int[] array) {
        int curr = 0, i = 0, step = 1, count = 0;
        while (i < array.length) {
            count += step;
            step *= 2;
        }
    }
}