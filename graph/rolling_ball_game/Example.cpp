bool solvable(const vector<string>& board, pair<int,int> start, pair<int,int> end) {
	if(board.empty() || board[0].empty()) {
		return false;
	}
	int m = (int)board.size(), n = (int)board[0].size();
	// m is the number of rows;
	// n is the number of columns.
	
	deque<pair<int,int>> q = {start};
	vector<vector<bool>> visited(m, vector<bool>(n, false));
	visited[start.first][start.second] = true;
	
	auto get_next = [&](int row, int col) {
		vector<pair<int,int>> next;
        bool found = false;
        for(int i = row + 1; i <= m; ++i)
            if(board[i][col] == '1') {
                next.push_back({i - 1, col});
                found = true;
                break;
            }
        if(!found && row != m - 1) next.emplace_back(m-1, col);
        found = false;
        
        for(int i = row - 1; i >= 0; --i)
            if(board[i][col] == '1') {
                next.push_back({i + 1, col});
                found = true;
                break;
            }
        if(!found && row != 0) next.emplace_back(0, col);
        found = false;
        
        for(int i = col + 1; i < n; ++i)
            if(board[row][i] == '1') {
                next.push_back({row, i - 1});
                found = true;
                break;
            }
        if(!found && col != n - 1) next.emplace_back(row, n-1);
        found = false;
        
        for(int i = col - 1; i >= 0; --i)
            if(board[row][i] == '1') {
                next.push_back({row, i + 1});
                found = true;
                break;
            }
        if(!found && col != 0) next.emplace_back(row, 0);
        return next;
    };
    
    while(!q.empty()) {
        auto cur = q.front();
        q.pop_front();
        
        auto next = get_next(cur.first, cur.second);
        for(auto n : next) {
            if(visited[n.first][n.second]) continue;
            visited[n.first][n.second] = true;
            if(n == end) return true;
            q.push_back(n);
        }
    }
    return false;
}