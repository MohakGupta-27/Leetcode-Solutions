class Solution {
    class Pair {
    int row;
    int column;

    Pair(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int minutes = 0;
        int fresh  = 0;
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0;i < n;i++){
            for(int j = 0;j <m;j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                if(grid[i][j] == 2){
                    q.offer(new Pair(i,j));
                }
            }
        }
        int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};

        while(!q.isEmpty() && fresh > 0){
            int size = q.size();
            for(int i = 0;i<size;i++){
                Pair p = q.poll();
                for(int[] d : dir){
                    int nr = p.row + d[0];
                    int nc = p.column + d[1];
                    if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 1){
                    grid[nr][nc] = 2;
                    fresh--;
                    q.offer(new Pair(nr, nc));
                    }
                }
            }
            minutes++;

        }
        if(fresh > 0)return -1;
        return minutes; 
    }
}