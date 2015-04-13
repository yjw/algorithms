public class Test {
    public static void main (String[] args) {
        Solution s = new Solution();
        for (int i = 0; i < 6553556; i++) {
            if (s.brute(i) != s.count(i)) {
                System.out.println("error");
                //System.out.println(i);
                //System.out.println("brute is " + s.brute(i));
                //System.out.println("count is " + s.count(i));
                return;
            }
        }
        System.out.println("Got it!");
    }
}
