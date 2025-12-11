class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;

        for(int num : nums){
          low = Math.max(low, num);
          high += num;
        }

        while(low < high){
            int mid = low + (high - low) / 2;

            if(canLargestSum(nums, mid, k)){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    private boolean canLargestSum(int[] nums, int mid, int k){
        int noOfPartition = 1;
        int countOfPartition = 0;

        for(int num : nums){
            if(countOfPartition + num > mid){
                noOfPartition++;
                countOfPartition = 0;
            }
            countOfPartition += num;
            if(noOfPartition > k) return false;
        }
          return noOfPartition <= k;

    }
}