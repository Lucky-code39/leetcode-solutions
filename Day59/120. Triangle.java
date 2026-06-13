class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
          
         int n = triangle.size();
         int[] dp = new int[n];

         for(int i = 0; i < n; i++){
            dp[i] = triangle.get(n - 1).get(i);
         }

         for(int row = n - 2; row >= 0; row--){
            for(int column = 0; column <= row; column++){
                dp[column] = triangle.get(row).get(column) + Math.min(dp[column], dp[column + 1]);
            }
         }
         return dp[0];
    }
}
