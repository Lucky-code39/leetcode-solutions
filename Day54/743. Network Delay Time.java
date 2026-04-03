class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());

        }

        for(int[] edge : times){
            int u = edge[0];
            int v = edge[1];
            int c = edge[2];

            adj.get(u).add(new int[]{v, c});
        }

        int[] dist = new int[n + 1];
        for(int i = 0; i <= n; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        dist[k] = 0;
        pq.add(new int[]{dist[k], k});

        while(!pq.isEmpty()){
           int[] node = pq.poll();

           int d = node[0];
           int vertex = node[1];

           if(d > dist[vertex]) continue;
            
            for(int[] edge : adj.get(vertex)){
                 int nei = edge[0];
                 int wt = edge[1];

                 if(d + wt < dist[nei]){
                    dist[nei] = d + wt;
                    pq.add(new int[]{dist[nei], nei});
                 }
            }

        }
        
        int max = 0;
        for(int i = 1; i <= n; i++){
          if(dist[i] == Integer.MAX_VALUE){
            return -1;
          }
          max = Math.max(max, dist[i]);
        }
       
       return max;
    }
}
