class Solution {
    public int shortestSubarray(int[] nums, int k) {

    int n = nums.length;
   long[] prefixSum = new long[n + 1];
   ArrayDeque<Integer> dq = new ArrayDeque<>();

    for(int i = 0; i < n; i++){
        prefixSum[i+1] = prefixSum[i] + nums[i];
    }

    int ans = Integer.MAX_VALUE;

    for(int j = 0; j <= n; j++){
          
          while(!dq.isEmpty() && prefixSum[j] - prefixSum[dq.peekFirst()] >= k){
            ans = Math.min(ans, j - dq.pollFirst());

          }

          while(!dq.isEmpty() && prefixSum[j] <= prefixSum[dq.peekLast()]){
            dq.pollLast();
          }

          dq.add(j);
    }

    return ans == Integer.MAX_VALUE ? -1 : ans;



        
    }
}