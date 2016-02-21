import java.util.TreeMap;
import java.util.Random;

public class Solution<E> {
    private final TreeMap<Double, E> map;
    private double total;
    private final Random random;
    Solution() {
        random = new Random();
        map = new TreeMap<Double, E>();
        total = 0.0;
    }
    
    public void add(double weight, E item) {
        total += weight;
        map.put(total, item);
    }

    public E next() {
        double value = random.nextDouble() * total;
        return map.ceilingEntry(value).getValue();
    }
}