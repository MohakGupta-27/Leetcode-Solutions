class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] pathvisited = new boolean[numCourses];

        List<List<Integer>> adj = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
 
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites)
            adj.get(pre[1]).add(pre[0]);
        for(int i = 0 ; i < numCourses;i++){
            if(!visited[i]){
                if(dfs(i,adj,st,visited,pathvisited)){
                    return new int[0];
                }
            }
        }
        int[] ans = new int[numCourses];
        int j = 0;
        while(!st.isEmpty()){
            ans[j++] = st.pop();
        }
        return ans;    
    }
    boolean dfs(int node,List<List<Integer>> adj,Stack<Integer> st,boolean[] visited,boolean[] pathvisited){
        visited[node]  = true;
        pathvisited[node] = true;
        for(int neighbour : adj.get(node)){
            if(!visited[neighbour]){
                if(dfs(neighbour,adj,st,visited,pathvisited)){
                    return true;
                }
            }else if(pathvisited[neighbour]){
                return true;
            }
        }
        st.push(node);
        pathvisited[node] = false;
        return false;
    }
}