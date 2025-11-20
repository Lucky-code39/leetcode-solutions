class Solution {
    public int[] getAverages(int[] nums, int k) {
        int[] arr = new int[nums.length];
        long[] prefix = new long[nums.length + 1];

        if(k == 0){
            return nums;
        }
        if(2*k + 1 > nums.length){
            Arrays.fill(arr, -1);
            return arr;
        }

        for(int i = 0; i < nums.length; i++){
            prefix[i + 1] = prefix[i] + nums[i];
        }

        for(int i = 0; i < nums.length; i++){
           
            if(i < k || i >= nums.length - k){
              arr[i] = -1;
            }
            else{
                int left = i - k;
                int right = i + k;

                long sum = prefix[right + 1] - prefix[left];
                arr[i] = (int) (sum / (2*k + 1));


        }
        }
        return arr;
    }
}
