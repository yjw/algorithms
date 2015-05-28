public class Solution {
	final TrieNode root = new TrieNode();
	public void addWord(String word) {
		root.addWord(word, 0);
	}
	public boolean search(String word) {
		return root.search(word, 0);
	}
}

class TrieNode {
	final TrieNode[] children = new TrieNode[26];
	boolean end = false;
	public void addWord(String word, int idx) {
		if (idx == word.length()) {
			end = true;
			return;
		}
        char c = word.charAt(idx);
        if(children[c - 'a'] == null) {
            children[c - 'a'] = new TrieNode();
        }
        children[c - 'a'].addWord(word, idx + 1);
    }

    public boolean search(String word, int idx) {
        if (idx == word.length()) {
            return end;
        }

        char c = word.charAt(idx);
        if (c != '.') {
            return children[c - 'a'] != null && children[c - 'a'].search(word, idx + 1);
        } else {
            for (int i = 0; i < 26; i++) {
                if (children[i] != null && children[i].search(word, idx + 1)) {
                    return true;
                }
            }
            return false;
        }
    }
}