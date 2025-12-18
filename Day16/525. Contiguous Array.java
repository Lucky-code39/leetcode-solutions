class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0 , -1);
        int maxLength = 0;
        int count = 0;

//Same count  twice means the subarray between them is balanced. equal number of 0 and 1 
// count = number of 1 - number of 0

       for(int i = 0; i < nums.length; i++){
        if(nums[i] == 0){
         count--;
        }
        else{
            count++;
        }

        if(map.containsKey(count)){
          maxLength = Math.max(maxLength, i - map.get(count));
        }
        else{
            map.put(count, i);
        }

       }
       return maxLength;

    }
}