import java.util.HashMap;

public class TrieNode {
	// There are actually two ways to 
	// One is to use HashMap
	// The other is to just use arrays
	// We actually don't need to assign a character
	// to the node as in the map, it's already been
	// associated with a character.
	public boolean isWordEnd;
	public char c;
	public HashMap<Character, TrieNode> children;
	TrieNode() {
		isWordEnd = false;
		children = new HashMap<Character, TrieNode>();
	}
}