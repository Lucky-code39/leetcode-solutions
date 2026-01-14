class Solution {
    public int[] nextGreaterElements(int[] nums) {

         
        int[] arr = new int[nums.length];
        Arrays.fill(arr, -1);
       int idx = 0;

       ArrayDeque<Integer> stack = new ArrayDeque<>();

       for(int i = 0; i < 2 * nums.length; i++){
            idx = i % nums.length;
            
            while(!stack.isEmpty() && nums[idx] > nums[stack.peek()]){
              arr[stack.pop()] = nums[idx];
            }

            if(i < nums.length){
                stack.push(idx);
            }

       }

       return arr;
       



        
    }
}