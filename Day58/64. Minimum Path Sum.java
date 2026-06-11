class Solution {
    public int minPathSum(int[][] grid) {
        
        int[][] dp = new int[grid.length][grid[0].length];
          
          
        for(int row = 0; row < grid.length; row++){
            if(row == 0){
              dp[0][0] = grid[0][0];
            }
            
            else{
                dp[row][0] = grid[row][0] + dp[row - 1][0];
            }
             
        }

        for(int column = 0; column < grid[0].length; column++){
            if(column == 0){
                dp[0][0] = grid[0][0];
            }

            else{
              dp[0][column] = grid[0][column] + dp[0][column - 1]; 
            }
            
        }

        for(int row = 1; row < grid.length; row++){
            for(int column = 1; column < grid[0].length; column++){
                dp[row][column] = grid[row][column] + Math.min(dp[row - 1][column], dp[row][column - 1]);

            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }
}
