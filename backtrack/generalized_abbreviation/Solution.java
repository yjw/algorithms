import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        if (word == null || word.length() < 1) {
            res.add("");
            return res;
        }
        helper(word, 0, 0, new StringBuilder(), res);
        return res;
    }

    private void helper(String word, int current, int count, StringBuilder sb, List<String> res) {
        if (current == word.length()) {
            String end = count == 0 ? "" : count + "";
            res.add(sb.toString() + end);
            return;
        }
        helper(word, current + 1, count + 1, sb, res);
        int len = sb.length();
        if (count != 0) {
            sb.append(count);
        }
        sb.append(word.charAt(current));
        helper(word, current + 1, 0, sb, res);
        sb.setLength(len);
    }
}