public class Islands {
    public int numIslands(char[][] grid) {
        if (grid.length < 1 || grid[0].length < 1) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    dfs(i, j, grid, visited);
                }
            }
        }
        return count;
    }
    
    private void dfs(int i, int j, char[][] grid, boolean[][] visited) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] == '0') {
            return;
        }
        visited[i][j] = true;
        dfs(i - 1, j, grid, visited);
        dfs(i + 1, j, grid, visited);
        dfs(i, j - 1, grid, visited);
        dfs(i, j + 1, grid, visited);
    }
}