import java.util.*;

public class Solution {
    public int squaretime (int[] array) {
        if (array == null) {
            return 0;
        }
        //int max = 0;
        int longest = 0;
        int[] dp = new int[array.length];
        dp[0] = 1;
        for (int i = 1; i < array.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    max = Math.max(dp[j] + 1, max);
                }
            }
            dp[i] = max;
            longest = Math.max(longest, max);
        }
        return longest;
    }
    
    public List<Integer> lis(int[] n) {
        List<Node<Integer>> pileTops = new ArrayList<Node<Integer>>();
        for (int x : n) {
	        Node<Integer> node = new Node<Integer>();
	        node.value = x;
            int i = Collections.binarySearch(pileTops, node);
            if (i < 0) i = ~i;
	        if (i != 0)
		        node.pointer = pileTops.get(i-1);
            if (i != pileTops.size())
                pileTops.set(i, node);
            else
                pileTops.add(node);
        }
        
        List<Integer> result = new ArrayList<Integer>();
        for (Node<Integer> node = pileTops.size() == 0 ? null : pileTops.get(pileTops.size()-1); node != null; node = node.pointer) {
            result.add(node.value);
        }
        Collections.reverse(result);
        return result;
    }
}

class Node<Integer> implements Comparable<Node<Integer>> {
	public int value;
	public Node<Integer> pointer;
        public int compareTo(Node<Integer> y) {
            if (this.value > y.value) {
                return 1;
            }
            else if (this.value < y.value) {
                return -1;
            }
            return 0;
        }
    }
