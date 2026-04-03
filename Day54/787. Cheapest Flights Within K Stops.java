class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
      

        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : flights){
            int u = edge[0];
            int v = edge[1];
            int c = edge[2];

            adj.get(u).add(new int[]{v, c});
        }

        int[][] dist = new int[n][k + 2];
        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

         pq.add(new int[]{0, src, 0});
         dist[src][0] = 0;

         while(!pq.isEmpty()){
              int[] curr = pq.poll();
              int cost = curr[0];
              int node = curr[1];
              int stops = curr[2];

              if(node == dst) return cost;

              if(stops > k) continue;

              for(int[] edge : adj.get(node)){
                int nei = edge[0];
                int wt = edge[1];

                if(cost + wt < dist[nei][stops + 1]){
                    dist[nei][stops + 1] = cost + wt;
                    pq.add(new int[]{cost + wt, nei, stops + 1});

                }
              }
         }
         return -1;
    }
}
