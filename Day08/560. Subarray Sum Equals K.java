class Solution {
    public int subarraySum(int[] nums, int k) {
        /* prefix sum logic = sum[L ... R] = prefix[R] - Prefix[L - 1] = k;
        which is prefix[L + 1] = prefix[R] - k; which means there is a 
        subarray whose sum is equal to k and to check this we need to use
        this formula prefix[L + 1] = prefix[R] - k;

        in this case this is prefix array of size equal to given array size 
        i.e. prefix[n] = sum[L ... R] = prefix[R] - Prefix[L - 1];

        there is another formula for prefix array where prefix array size is one greater than given array size 
        prefix[n + 1] = sum[L ... R] = prefix[R + 1] - Prefix[L];
        */
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefix = 0;
        int count = 0;
         
         for(int num : nums){
            

            prefix += num;
             int need = prefix - k;

             if(map.containsKey(need)){
                count += map.get(need);
             }

             map.put(prefix, map.getOrDefault(prefix, 0) + 1);
         }

         return count;

        
    }
}