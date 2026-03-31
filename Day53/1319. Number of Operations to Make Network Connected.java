class Solution {
    int[] parent;
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n -1) return -1;
        
        parent = new int[n];
        int extraEdges = 0;

        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        for(int[] c : connections){
            int u = c[0];
            int v = c[1];

            if(find(u) == find(v)){
              extraEdges++;
            }
            else{
                union(u, v);
            }

        }

        int component = 0;
        for(int i = 0; i < n; i++){
            if(parent[i] == i){
                component++;
            }
        }

        return component - 1;







    }

    private int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int u, int v){
        int pa = find(u);
        int pb = find(v);

        if(pa != pb){
            parent[pa] = pb;
        }
    }
}