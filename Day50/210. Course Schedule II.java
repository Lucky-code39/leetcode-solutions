class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        

        int n = numCourses;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] arr : prerequisites){
            adj.get(arr[1]).add(arr[0]);
        }

        boolean[] visited = new boolean[n];
        boolean[] pathvisited = new boolean[n];
        
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                if(dfs(i, adj, visited, pathvisited, stack)){
                    return new int[0];
                }
            }
        }
      int[] result = new int[numCourses];
      int i = 0;
      while(!stack.isEmpty()){
        result[i] = stack.pop();
        i++;
      }
      return result;
    }
    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] pathvisited, Stack<Integer> stack){
        visited[node] = true;
        pathvisited[node] = true;

        for(int neighbor : adj.get(node)){
            if(!visited[neighbor]){
              if(dfs(neighbor, adj, visited, pathvisited, stack)){
                return true;
              }

            }
            else if(pathvisited[neighbor]){
                return true;
            }
        }
        pathvisited[node] = false;
        stack.push(node);
        return false;
    }

}
