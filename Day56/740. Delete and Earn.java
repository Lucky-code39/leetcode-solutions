class Solution {
    public int deleteAndEarn(int[] nums) {
       if(nums.length == 1) return nums[0];

       int max = 0;

       for(int num : nums){
        max = Math.max(max, num);
       }

       int[] points = new int[max + 1];

       for(int num : nums){
        points[num] += num;
       }

      int prev2 = 0;
      int prev1 = points[0];

       for(int i = 1; i <= max; i++){
        int curr = Math.max(prev1, points[i] + prev2);
        prev2 = prev1;
        prev1 = curr;
       }

       return prev1;
    }
}