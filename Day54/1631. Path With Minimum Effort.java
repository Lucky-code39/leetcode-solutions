class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[] rows = {-1, 1, 0, 0};
        int[] columns = {0, 0, -1, 1};

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

       int[][] efforts = new int[m][n];

       for(int i = 0; i < m; i++){
        Arrays.fill(efforts[i], Integer.MAX_VALUE);
       }

       pq.add(new int[]{0, 0, 0});  //effort, row, col.
       efforts[0][0] = 0;

       while(!pq.isEmpty()){
        int[] curr = pq.poll();
        int currentEffort = curr[0];
        int row = curr[1];
        int column = curr[2];

          if(row == m - 1 && column == n - 1){
            return currentEffort;
          }

        if(currentEffort > efforts[row][column]) continue;

        for(int i = 0; i < 4; i++){
            int tr = row + rows[i];
            int tc = column + columns[i];

            if(tr >= 0 && tr < m && tc >= 0 && tc < n){
                int diff = Math.abs(heights[row][column] - heights[tr][tc]);
                int newEffort = Math.max(currentEffort, diff);

                if(newEffort < efforts[tr][tc]){
                    efforts[tr][tc] = newEffort;
                    pq.add(new int[]{newEffort, tr, tc});
                }
            }
        }
       }
     return 0;
    }
}