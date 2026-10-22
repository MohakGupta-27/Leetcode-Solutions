class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited  = new boolean[n][m];
        int count = 0;
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m;j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    count++;
                    dfs(grid,i,j,visited);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid,int r,int c,boolean[][] visited){
        int n = grid.length;
        int m = grid[0].length;
        if(r < 0 || c < 0 || r >= n || c >= m || grid[r][c] == '0' || visited[r][c]){return;}
        visited[r][c] = true;
        dfs(grid,r+1,c,visited);
        dfs(grid,r-1,c,visited);
        dfs(grid,r,c-1,visited);
        dfs(grid,r,c+1,visited);
    }
}