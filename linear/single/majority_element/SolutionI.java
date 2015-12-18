public class SolutionI {
    public int majorityElement(int[] num) {
        int count = 1;
        int p = num[0];
        for (int i = 1; i < num.length; i++) {
            if (num[i] == p) {
                count++;
            }
            else {
                
                if (count == 0) {
                    count++;
                    p = num[i];
                }
                else {
                    count--;
                }
            }
        }
        return p;
    }
    
    public int bit_method(int[] num) {
    	
    }
}