import java.util.ArrayList;

public class Graph {
    private int V;
    private int E;
    private ArrayList<Integer>[] adj;
    
    Graph(int V) {
        this.V = V;
        E = 0;
        adj = (ArrayList<Integer>[]) new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
    }
    
    public int V () {
        return V;
    }
    
    public int E () {
        return E;
    }
    
    public void addEdge(int a, int b) {
        adj[a].add(b);
        adj[b].add(a);
        E++;
    }
    
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
