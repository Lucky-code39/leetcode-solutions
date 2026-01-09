class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] arr = {-1, -1};

        arr[0] = findFirst(nums, target);//first occcurence of target
        arr[1] = findLast(nums, target);//last occurence of target

               return arr;
       

    }
     private int findFirst(int[] nums, int target){
            int low = 0;
            int high = nums.length - 1;
            int ans = -1;
            while(low <= high){
              int mid = low + (high - low) / 2;
                if(nums[mid] == target){
                  ans = mid;//possible answer
                  high = mid - 1;//keep searching in left
                }
                else if(nums[mid] < target){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
            return ans;
        }
              private int findLast(int[] nums, int target){
                  int low = 0;
            int high = nums.length - 1;
            int ans = -1;
            while(low <= high){
              int mid = low + (high - low) / 2;
                if(nums[mid] == target){
                  ans = mid;//possible answer
                  low = mid + 1;//keep searching in right
                }
                else if(nums[mid] < target){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
            return ans;
        }
}
