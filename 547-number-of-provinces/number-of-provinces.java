class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int size = isConnected.length;
        boolean visited[] = new boolean[size];
        for (int i = 0; i < size; i++) {
            if(!visited[i]){
                count++;
                dfs(i,isConnected,visited);
            }
        }
        return count;
    }
    void dfs(int start, int[][] isConnected,boolean[] visited){
        visited[start] = true;
        for(int j = 0;j < isConnected.length;j++){
            if(isConnected[start][j] == 1 && !visited[j]){
                dfs(j,isConnected,visited);
            }
        }
    }
}