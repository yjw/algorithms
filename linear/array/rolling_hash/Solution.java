import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        ArrayList<String> res = new ArrayList<String>();
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        if (s.length() < 11) {
            return res;
        }
        long value = 0;
        int radix = 1;
        for (int i = 0; i < 9; i++) {
            radix = radix * 4;
        }
        for (int i = 0; i < 10; i++) {
            char c = s.charAt(i);
            value = value * 4 + num(c);
        }
        map.put(value, 1);
        for (int i = 10; i < s.length(); i++) {
            value = value % radix;
            value = value * 4 + num(s.charAt(i));
            if (map.containsKey(value)) {
                map.put(value, map.get(value)+ 1);
            }
            else {
                map.put(value, 1);
            }
        }
        
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if ((int)pair.getValue() > 1) {
                res.add(trans((long)pair.getKey()));
            }
        }
        
        return res;
    }
    
    private int num (char c) {
        if (c == 'A') {
            return 0;
        }
        if (c == 'C') {
            return 1;
        }
        if (c == 'G') {
            return 2;
        }
        else {
            return 3;
        }
    }
    
    public String trans (long value) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            long temp = value % 4;
            if (temp == 0) {
                sb.append('A');
            }
            if (temp == 1) {
                sb.append('C');
            }
            if (temp == 2) {
                sb.append('G');
            }
            if (temp == 3) {
                sb.append('T');
            }
            value = value / 4;
        }
        return sb.toString();
    }
}