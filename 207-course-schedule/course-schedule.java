class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] pathvisited = new boolean[numCourses];

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites)
            adj.get(pre[1]).add(pre[0]);
        for(int i = 0 ; i < numCourses;i++){
            if(!visited[i]){
                if(dfs(i,adj,visited,pathvisited)){
                    return false;
                }
            }
        }
        return true;

    }
    boolean dfs(int node,List<List<Integer>> adj,boolean[] visited,boolean[] pathvisited){
        visited[node]  = true;
        pathvisited[node] = true;
        for(int neighbour : adj.get(node)){
            if(!visited[neighbour]){
                if(dfs(neighbour,adj,visited,pathvisited)){
                    return true;
                }
            }else if(pathvisited[neighbour]){
                return true;
            }
        }
        pathvisited[node] = false;
        return false;
    }
}