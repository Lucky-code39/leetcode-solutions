class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
          sum += nums[i];

          if(k != 0) sum %= k; //unnecessary as constrains itself states that 1 <= k <= 231 - 1

          if(map.containsKey(sum)){
             // check length >= 2
            if(i - map.get(sum) >= 2){
                return true;
            }
          }
          else{
            map.put(sum, i);// store earliest index of this remainder
          }
        }
         return false;
    }
}
