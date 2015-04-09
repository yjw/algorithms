public class Solution {
    public int find(int[] array) {
        if (array == null || array.length < 1) {
            return -1;
        }
        if (array.length < 2) {
            return array[0];
        }
        int len = array.length;
        int one = array[len / 4];
        int two = array[len / 2];
        int three = array[(len / 4) * 3];
        if (one == two) {
            return one;
        }
        if (two == three) {
            return two;
        }
        
    }
    
    private int find_lo (int[] array, int target, int lo, int hi) {
        
    }
}
