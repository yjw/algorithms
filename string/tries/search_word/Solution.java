import java.util.List;
import java.util.ArrayList;

public class Solution {
	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<String>();
	}
	YTrieNode root = new YTrieNode();
	root.map = null;
	private YTrieNode buildT (String[] words, YTrieNode root) {
		
	}
}

class YTrieNode {
	boolean isWord;
	HashMap<Character, YTrieNode> map;
	YTrieNode() {
		isWord = false;
		map = new HashMap<Character, YTrieNode>();
	}
}
