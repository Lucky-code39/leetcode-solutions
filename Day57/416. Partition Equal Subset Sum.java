package Day57;

public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for(int num : nums){
            sum += num;
        }

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];

        if(sum % 2 != 0) return false;
       dp[0] = true;

        for(int num : nums){
        
        for(int s = target; s >= num; s--){
           dp[s] = dp[s] || dp[s - num];
        }
        }
           return dp[target];
    }
} {
    
}
