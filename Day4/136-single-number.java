class Solution {
    public int singleNumber(int[] nums) {

        int result = 0;

        for(int element : nums){
            result = result ^ element;
        }

        return result;

        
    }
}