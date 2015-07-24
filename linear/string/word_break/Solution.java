import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0)
            return new ArrayList<String>();
        int n = s.length();
        boolean[] wb = new boolean[n+1];
        wb[0] = true;
        List<List<String>> words = new ArrayList<List<String>>();
        for (int i = 0; i <= n; i++)
            words.add(new ArrayList<String>());
        words.get(0).add("");
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String temp = s.substring(j, i);
                if (wb[j] && dict.contains(temp)) {
                    wb[i] = true;
                    for (String str : words.get(j)) {
                        if (str.equals(""))
                            words.get(i).add(String.format("%s", temp));
                        else
                            words.get(i).add(String.format("%s %s", str, temp));
                    }
                }
            }
        }
        return words.get(n);
    }
}