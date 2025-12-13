class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return new int[0];

        int n = nums.length;

        int[] ans = new int[n - k + 1];
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            //removing indices out of window
            if(!dq.isEmpty() && dq.peekFirst() <= i - k){
                dq.pollFirst();
            }

            //removing smaller elements from back
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }

            //add current index
            dq.offerLast(i);
        

        //record max when window is ready
           
           if(i >= k - 1){
            ans[i - k + 1] = nums[dq.peekFirst()];
           }
       
        }
        return ans;
    }
}