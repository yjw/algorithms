public class TrieNode {
	boolean end;
	TrieNode[] kids;
	TrieNode() {
		end = false;
		kids = new TrieNode[26];
	}
	public void add (String word, int idx) {
		if (idx == word.length) {
			end = true;
			return;
		}
		char c = word.charAt(idx);
		if (kids[c - 'a'] == null) {
			TrieNode t = new TrieNode();
			kids[c - 'a'] = t;
			return;
		}
		kids[c - 'a'].add(word, idx + 1);
	}
	
	public boolean search(String word, int idx) {
		if (idx == word.length()) {
			return end;
		}
		char c = word.charAt(idx);
		
	}
}