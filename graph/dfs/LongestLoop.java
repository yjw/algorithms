public class LongestLoop {
	private int max;
	int[] out;
	int num;
	boolean[] visited;
	int[] order;
	public int loop(int[] array) {
		int num = array.length;
		out = array;
		visited = new boolean[num];
		order = new int[num];
		max = 0;
		int counter = 0;
		for (int i = 0; i < num; i++) {
			dfs(i, counter);
		}
		return max;
	}
	
	private int dfs(int p, int counter) {
		if (!visited[p]) {
				order[p] = counter++;
				visited[p] = true;
				dfs(out[p], counter);
			}
			else {
				int temp = counter - order[p];
				max = Math.max(temp, max);
			}
			return max;
	}
}