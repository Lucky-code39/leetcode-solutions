class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        
        int maxArea = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    int count = 0;
                   maxArea = Math.max(bfs(grid, i, j, count), maxArea);
                }
            }
        }
        return maxArea;
    }
    private int bfs(int[][] grid, int sr, int sc, int count){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});

        grid[sr][sc] = 0;
        count++;
        
        int[] rows = {-1, 1, 0, 0};
        int[] columns = {0, 0, -1, 1};

        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int row = node[0];
            int column = node[1];

            for(int i = 0; i < 4; i++){
                int tr = row + rows[i];
                int tc = column + columns[i];

                if(tr >= 0 && tr < grid.length && tc >= 0 && tc < grid[0].length){
                    if(grid[tr][tc] == 1){
                        queue.add(new int[]{tr, tc});
                        grid[tr][tc] = 0;
                        count++;
                    }
                }
            }
        }
        return count;

    }
}