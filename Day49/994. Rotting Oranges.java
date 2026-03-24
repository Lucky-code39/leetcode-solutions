class Solution {
    public int orangesRotting(int[][] grid) {
    
         int time = 0;
         int fresh =  0;
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
         if(fresh == 0) return 0;
         int minMinutes = bfs(grid, queue, fresh, time);

         return minMinutes;
    }
    private int bfs(int[][] grid, Queue<int[]> queue, int fresh, int time){
        
             while(!queue.isEmpty()){
                boolean rotted = false;
                int size = queue.size();

                for(int i = 0; i < size; i++){
               int[] node = queue.poll();

               int row = node[0];
               int column = node[1]; 

               int[] rows = {-1, 1, 0, 0};
               int[] columns = {0, 0, -1, 1};

               for(int j = 0; j < 4; j++){
                int tr = row + rows[j];
                int tc = column + columns[j];

                if(tr >= 0 && tr < grid.length && tc >= 0 && tc < grid[0].length){
                    if(grid[tr][tc] == 1){
                        grid[tr][tc] = 2;
                        queue.add(new int[]{tr, tc});
                        fresh--;
                        rotted = true;
                    }
                }

               }
                
        }
        if(rotted) time++;
             }
        
        if(fresh == 0){
            return time;
        }
        else{
            return -1;
        }

    }
}
