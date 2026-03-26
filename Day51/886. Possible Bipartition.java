class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        

        for(int i = 1; i <= n + 1; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] p : dislikes){
            adj.get(p[0]).add(p[1]);
            adj.get(p[1]).add(p[0]);
        }

        int[] color = new int[n + 1];
        Arrays.fill(color, -1);

        for(int i = 1; i <= n; i++){
            if(color[i] == -1){

                if(!bfs(adj, color, i)) return false;
            }
        }
        return true;
    }
    private boolean bfs(ArrayList<ArrayList<Integer>> adj, int[] color, int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        color[node] = 0;

        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int neighbor : adj.get(curr)){
              if(color[neighbor] == -1){
                color[neighbor] = 1 - color[curr];
                queue.add(neighbor);
              }
              else if(color[curr] == color[neighbor]){
                return false;
              }
            }
        }

        return true;
    }
}
