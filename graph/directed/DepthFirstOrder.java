import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;
    
    DepthFirstOrder (Digraph G) {
        marked = new boolean[G.V()];
        pre = new LinkedList<Integer>();
        post = new LinkedList<Integer>();
        reversePost = new Stack<Integer>();
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }
    
    private void dfs (Digraph G, int v) {
        marked[v] = true;
        pre.offer(v);
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        post.offer(v);
        reversePost.push(v);
    }
    
    public Iterable<Integer> preorder () {
        return pre;
    }
    
    public Iterable<Integer> postorder () {
        return post;
    }
    
    public Iterable<Integer> reversePost () {
        return reversePost;
    }
}
