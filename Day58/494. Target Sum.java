class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int totalSum = 0;

        for(int num : nums){
            totalSum += num;
        }

        if(Math.abs(target) > totalSum) return 0;

        if((totalSum + target) % 2 != 0 ) return 0;

        int subSetSum = (totalSum + target) / 2;

        int[] dp = new int[subSetSum + 1];
        dp[0] = 1;


        for(int num : nums){

            for(int s = subSetSum; s >= num; s--){
                dp[s] += dp[s - num];
            }

        }

        return dp[subSetSum];
    }
}