class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;
        if(grid[0][0] == 1) return -1;

        Queue<int[]> queue = new LinkedList<>();
       

        queue.add(new int[]{0, 0, 1});
        grid[0][0] = 1;

        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1},
                       {0, -1},           {0, 1},
                       {1, -1}, {1, 0}, {1, 1}
                       };

                       while(!queue.isEmpty()){
                        int[] node = queue.poll();
                        int row = node[0];
                        int column = node[1];
                        int distance = node[2];

                        if(row == n - 1 && column == n -1){
                            return distance;
                        }
                       
                       for(int[] element : dirs){
                        int tr = row + element[0];
                        int tc = column + element[1];

                        if(tr >= 0 && tr < n && tc >= 0 && tc < n && grid[tr][tc] == 0){
                            queue.add(new int[]{tr, tc, distance + 1});
                            grid[tr][tc] = 1;
                        }
                       }

                       }

                       return -1;
    }
}