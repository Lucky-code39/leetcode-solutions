class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int n = numCourses;

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] arr : prerequisites){
            adj.get(arr[1]).add(arr[0]);
        }

        boolean[] visited = new boolean[n];
        boolean[] pathvisited = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!visited[i]){
             if(dfs(i, adj, visited, pathvisited)){
                return false;
             }
            }
        }
    return true;
    }

    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] pathvisited){

        visited[node] = true;
        pathvisited[node] = true;

        for(int neighbor : adj.get(node)){
            if(!visited[neighbor]){
                if(dfs(neighbor, adj, visited, pathvisited)){
                    return true;
                }
            }
            else if(pathvisited[neighbor]){
               return true;
            }
        }
        pathvisited[node] = false;
        return false;
    }
}
