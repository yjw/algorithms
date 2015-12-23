import java.util.List;
import java.util.ArrayList;

public class MySolution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        if (word == null || word.length() < 1) {
            res.add("");
            return res;
        }
        return helper(word);
    }

    private List<String> helper(String word) {
        List<String> res = new ArrayList<String>();
        if (word == null || word.length() < 1) {
            return res;
        }
        if (word.length() == 1) {
            res.add(word);
            res.add("1");
            return res;
        }
        char c = word.charAt(0);
        List<String> item = helper(word.substring(1));
        for (String x : item) {
            res.add(c + x);
        }
        for (String x : item) {
            res.add(increment(x));
        }
        return res;
    }

    private String increment(String x) {
        if (x == null || x.length() < 1) {
            return x;
        }
        int i = 0;
        while (i < x.length() && x.charAt(i) <= '9' && x.charAt(i) >= '0') {
            i++;
        }
        if (i == 0) {
            return "1" + x;
        }
        int num = Integer.parseInt(x.substring(0, i));
        num++;
        return String.valueOf(num) + x.substring(i);


    }
}