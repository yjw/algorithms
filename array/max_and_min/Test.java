public class Test {
    public static void main (String[] args) {
        Solution s = new Solution();
        int[] array = {7,5,8,9,10, 1, 5, 2, 19, 12, 4, -7, 100};
        int[] t = s.max_min(array);
        System.out.println(t[0]);
        System.out.println(t[1]);
    }
}