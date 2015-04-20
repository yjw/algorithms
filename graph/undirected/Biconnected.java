package undirected;

public class Biconnected {
	private int[] low;
	private int[] pre;
	private int cnt;
	private boolean[] articulation;

	public Biconnected(Graph G) {
		low = new int[G.V()];
		pre = new int[G.V()];
		articulation = new boolean[G.V()];
		for (int v = 0; v < G.V(); v++) {
			low[v] = -1;
		}
		for (int v = 0; v < G.V(); v++) {
			pre[v] = -1;
		}
		// If the prev doesn't exist, dfs it.
		for (int v = 0; v < G.V(); v++) {
			if (pre[v] == -1) {
				dfs(G, v, v);
			}
		}
	}

	private void dfs(Graph G, int u, int v) {
		int children = 0;
		pre[v] = cnt++;
		low[v] = pre[v];
		for (int w : G.adj(v)) {
			if (pre[w] == -1) {
				children++;
				dfs(G, v, w);
				low[v] = Math.min(low[v], low[w]);
				if (low[w] >= pre[v] && u != v) {
					articulation[v] = true;
				}
			} else if (w != u) {
				low[v] = Math.min(low[v], pre[w]);
			}
		}
		if (u == v && children > 1) {
			articulation[v] = true;
		}
	}

	public boolean isArticulation(int v) {
		return articulation[v];
	}
}
