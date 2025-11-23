class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] productExceptSelf = new int [nums.length];
         
         productExceptSelf[0] = 1;

         for(int i = 1; i < nums.length; i++){
            productExceptSelf[i] = productExceptSelf[i - 1] * nums[i - 1];
         }

         int right = 1;

         for(int i = nums.length - 1; i >= 0; i--){
            productExceptSelf[i] = productExceptSelf[i] * right;
            right *= nums[i];


         }
        
       return productExceptSelf;
    }
}