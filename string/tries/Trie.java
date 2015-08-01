public class Trie {
	private TrieNode root;
	public Trie() {
		root = new TrieNode();
	}

    // Inserts a word into the trie.
    public void insert(String word) {
        char[] array = word.toCharArray();
        TrieNode p = root;
        int i = 0, len = array.length;
        while (i < len) {
        	TrieNode next = p.children.get(array[i]);
        	if (next != null) {
        		p = next;
        		i++;
        	}
        	else {
        		break;
        	}
        }
        while (i < len) {
        	TrieNode newTrie = new TrieNode();
        	p.children.put(array[i], newTrie);
        	p = newTrie;
        	i++;
        }
        p.isWordEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode p = find(root, word);
        return p != null && p.isWordEnd;
    }
    
    private TrieNode find (TrieNode root, String word) {
    	TrieNode p = root;
    	for (int i = 0; i < word.length(); i++) {
    		if (p.children.get(word.charAt(i)) != null) {
    			p = p.children.get(word.charAt(i));
    		}
    		else {
    			return null;
    		}
    	}
    	return p;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode p = find(root, prefix);
        return p != null;
    }
}