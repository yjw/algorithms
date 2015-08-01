import java.util.ArrayList;
import java.util.Set;
import java.util.List;

public class Solution_one {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    	List<List<String>> res = new ArrayList<List<String>>();
    	ArrayList<String> path = new ArrayList<String>();
    	path.add(start);
    	solve(start, end, dict, path, res);
    	
    	int min = Integer.MAX_VALUE;
    	for (List<String> x : res) {
    		if (x.size() < min) {
    			min = x.size();
    		}
    	}
    	List<List<String>> result = new ArrayList<List<String>>();
    	for (List<String> x : res) {
    		if (x.size() == min) {
    			result.add(x);
    		}
    	}
		return result;
    }
    
    private void solve(String start, String end, Set<String> dict, ArrayList<String> path, List<List<String>> res) {
    	char[] array = start.toCharArray();
    	for (int i = 0; i < start.length(); i++) {
    		for (int j = 0; j < 26; j++) {
    			if (array[i] == 'a' + j) {
    				continue;
    			}
    			char c = array[i];
    			array[i] = (char) ('a' + j);
    			String temp = String.valueOf(array);
    			array[i] = c;
    			if (temp.equals(end)) {
    				ArrayList<String> t = new ArrayList<String>(path);
    				t.add(end);
					res.add(t);
					return;
				}
    			if (dict.contains(temp) && !path.contains(temp)) {
    				path.add(temp);
    				solve(temp, end, dict, path, res);
    				path.remove(path.size() - 1);
    			}
    		}
    	}
    }
}
