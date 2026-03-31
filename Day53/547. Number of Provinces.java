class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++){
            if(visited[i] != true){
                bfs(i, isConnected, visited);
                count++;
            }
              
        }

        return count;
    }
    private void bfs(int start, int[][] isConnected, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();

            for(int j = 0; j < isConnected.length; j++){
                if(isConnected[node][j] == 1 && visited[j] != true){
                    visited[j] = true;
                    queue.add(j);

                }
            }
        }
    }
}