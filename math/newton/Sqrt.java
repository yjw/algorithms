public class Sqrt {
    public int sqrt(int x) {
        long i = 0;
        long j = x / 2 + 1;
        while (i <= j) {
            long mid = (i + j) / 2;
            long sq = mid * mid;
            if (sq == x) {
                return mid;
            }
            else if (sq < x) {
                i = mid + 1;
            }
            else
                j = mid - 1;
        }
        return j;
    }
    public int sqrt1(int x) {
        if (x == 0)
            return 0;
        double last = 0;
        double res = 1;
        while (res != last) {
            last = res;
            res = (res + x / res) / 2;
        }
        return (int)res;
    }
    
    public double sqrt2 (double x) {
        if (x == 0)
            return 0;
        double last = 0.0;
        double res = 1.0;
        while (res != last) {
            last = res;
            res = (res + x / res) / 2;
        }
        return res;
    }
}