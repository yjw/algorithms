import java.util.Iterator;

// This code is not complex at all. It teaches me to 
// think about using Iterators to traverse the graph.

public class DirectedEulerianCycle {
    private Stack<Integer> cycle = new Stack<Integer>();
    private boolean isEulerian = true;
    public DirectedEulerianCycle(Digraph G) {
        Iterator<Integer>[] adj = (Iterator<Integer>[]) new Iterator[G.V()];
        for (int v = 0; v < G.V(); v++) {
            adj[v] = G.adj(v).iterator();
        }
        int s = 0;
        for (int v = 0; v < G.V(); v++) {
            if (adj[v].hasNext()) {
                s = v;
                break;
            }
        }
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(s);
        while (!stack.isEmpty()) {
            int v = stack.pop();
            cycle.push(v);
            int w = v;
            while (adj[w].hasNext()) {
                stack.push(w);
                w = adj[w].next();
            }
            if (w != v) {
                isEulerian = false;
            }
        }
        
        for (int v = 0; v < G.V(); v++) {
            if (adj[v].hasNext()) {
                isEulerian = false;
            }
        }
    }

    // return Eulerian cycle, or null if no such tour
    public Iterable<Integer> cycle() {
        if (!isEulerian) return null;
        return cycle;
    }

    // does the digraph have an Eulerian tour?
    public boolean isEulerian() {
        return isEulerian;
    }
}