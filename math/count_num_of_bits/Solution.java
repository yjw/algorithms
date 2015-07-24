public class Solution {
    // Brian Kernighan’s Algorithm
    public int count (int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }
    
    // Divide and conquer without loop
    public int counti (int num) {
        
    }
}