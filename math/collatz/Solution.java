import java.util.BitSet;

public class Solution {
    // we firstly provide a naive solution 
    // ignoring the overflow
    // Just return the number of odd and even numbers
    public void naive (int n) {
        int num = n;
        int even = 0, odd = 0;
        while (num != 1) {
            if (num % 2 == 0) {
                num = num / 2;
                even++;
            }
            else {
                num = 3 * num + 1;
                odd++;
            }
        }
        System.out.println("Number of odd number is " + odd);
        System.out.println("Number of even number is " + even);
    }
    
    // We use bitset as the 
    public void mbit (int n) {
        BitSet b = itob(n);
        BitSet one = itob(1);
        int even = 0, odd = 0;
        while (!isOne(b)) {
            if (b.get(0)) {
                odd++;
                b = add(add(add(b, b), b), one);
            }
            else {
                b = right_shift(b);
                even++;
            }
        }
        System.out.println("Odd number is " + odd);
        System.out.println("Even number is " + even);
    }
    
    private BitSet itob (int num) {
        BitSet b = new BitSet();
        for (int i = 0; i < 32; i++) {
            if (((num >> i) & 1) == 1) {
                b.set(i);
                
            }
        }
        return b;
    }
    
    private boolean isOne(BitSet b) {
        return b.cardinality() == 1 && b.get(0);
    }
    
    private BitSet add (BitSet m, BitSet n) {
        if (n.isEmpty()) {
            return m;
        }
        BitSet carry = new BitSet();
        carry.or(m);
        carry.and(n);
        BitSet num = new BitSet();
        num.or(m);
        num.xor(n);
        carry = left_shift(carry);
        return add(num, carry);
    }
    
    private BitSet left_shift (BitSet b) {
        BitSet ret = new BitSet();
        for (int i = b.nextSetBit(0); i >= 0; i = b.nextSetBit(i + 1)) {
            ret.set(i + 1);
        }
        return ret;
    }
    
    private BitSet right_shift(BitSet b) {
        
        return b.get(1, b.length());
    }
}