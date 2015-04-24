// how to implement rand10() with 
// rand7()

public class Solution {
    int rand10() {
        int x = 0;
        do {
            x = (rand7() - 1) * 7 + rand7();
        } while(x > 40);
        return x % 10 + 1;
    }
}