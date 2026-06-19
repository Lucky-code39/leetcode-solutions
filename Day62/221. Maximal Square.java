class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int[][] dp = new int[matrix.length][matrix[0].length];

        int maxSide = 0;

        for(int row = 0; row < matrix.length; row++){
            for(int column = 0; column < matrix[row].length; column++){

                if(matrix[row][column] == '1'){

                    if(row == 0 || column == 0){
                        dp[row][column] = 1;
                    }

                    else{
                        dp[row][column] = 1 + Math.min(dp[row - 1][column],
                         Math.min(dp[row][column - 1], dp[row - 1][column - 1])
                         );
                        
                    }
                     maxSide = Math.max(maxSide, dp[row][column]);
                }
            }
        }

        return maxSide * maxSide;
    }
}
