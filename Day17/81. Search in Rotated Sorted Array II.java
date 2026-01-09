class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

       while(low <= high){
        int mid = low + (high - low) / 2;
        if(nums[mid] == target) return true;
         
            // 🔴 duplicates case — cannot determine sorted half
       if(nums[low] == nums[mid] && nums[mid]== nums[high]){
        low++;
        high--;
       }

       else if(nums[low] <= nums[mid]){//left part is sorted
        if(target >= nums[low] && target < nums[mid]){
            high = mid - 1;
        }
        else{
            low = mid + 1;
        }
       }

       else{//right part is sorted
       if(target > nums[mid] && target <= nums[high]){
        low = mid + 1;
       }
       else{
        high = mid - 1;
       }

       }

       }
       return false;
    }
}
