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
        int count = 0;
        int len = Integer.toString(num).length();
        for (int i = 0; i < len; i++) {
            
            count += digit_count(num, i);
            //System.out.println("***count is " + count);
        }
        return count;
    }
    
    private int digit_count(int num, int i) {
        String str = Integer.toString(num);
        assert i < Integer.toString(num).length() && i >= 0;
        int poweroften = (int)Math.pow(10, i);
        int nextpoweroften = poweroften * 10;
        int rounddown = num / nextpoweroften; // 2
        int roundup = (num + nextpoweroften) / nextpoweroften ; // 
        //System.out.println("round down is " + rounddown);
        //System.out.println("round up is " + roundup);
        if (str.charAt(str.length() - i - 1) < '2') {
            return rounddown * poweroften;
        }
        if (str.charAt(str.length() - i - 1) > '2') {
            return roundup * poweroften;
        }
        else {
            return rounddown * poweroften + num % poweroften + 1;
        }
    }
}
