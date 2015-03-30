public class Solution {
    public int brute (int num) {
        int count = 0;
        for (int i = 2; i <= num; i++) {
            count += brute_count(i);
        }
        return count;
    }
    
    private int brute_count (int num) {
        int count = 0;
        while (num > 0) {
            if (num % 10 == 2) {
                count++;
            }
            num = num / 10;
        }
        return count;
    }
    
    public int count (int num) {
        
    }
    
    private int 
    
}
