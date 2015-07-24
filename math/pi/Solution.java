import java.util.Random;
import java.lang.Math;

public class Solution {
    /*
     First, use Monte Carlo method.
     Refer to picture 1.
    */
    public double calculate() {
        long inside = 0;
        long total = 1000000000;
        Random r = new Random();
        for (int i = 0; i < total; i++) {
            double x = r.nextDouble(); 
            double y = r.nextDouble();
            if (Math.sqrt(x * x + y * y) < 1) {
                inside++;
            }
        }
        return 4 * ((double)inside / (double)total);
    }
}
