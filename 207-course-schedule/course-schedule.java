class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] pathvisited = new boolean[numCourses];

        ArrayList<Integer>[] adj = new ArrayList[numCourses];

        for(int i = 0; i < numCourses; i++){
            adj[i] = new ArrayList<>();
        }

        // Build graph
        for(int[] pair : prerequisites){
            int course = pair[0];
            int prerequisite = pair[1];

            adj[prerequisite].add(course);
        }
        for(int i = 0 ; i < numCourses;i++){
            if(!visited[i]){
                if(dfs(i,adj,visited,pathvisited)){
                    return false;
                }
            }
        }
        return true;

    }
    boolean dfs(int node,ArrayList<Integer>[] adj,boolean[] visited,boolean[] pathvisited){
        visited[node]  = true;
        pathvisited[node] = true;
        for(int neighbour : adj[node]){
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