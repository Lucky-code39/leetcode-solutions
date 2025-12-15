class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
  
    int i = m - 1;
    int j = n - 1;
    int k = m + n -1;

  // We merge from the back to avoid overwriting elements in nums1
// since the empty slots are at the end.

    while(i >= 0 && j >= 0){
        if(nums1[i] > nums2[j]){
            nums1[k] = nums1[i];
            i--;
            
        }
        else{
            nums1[k] = nums2[j];
            j--;
            
        }
        k--;
    }

    // Only nums2 may have remaining elements.
// Remaining nums1 elements are already in correct position.

    while(j >= 0){
        nums1[k] = nums2[j];
        j--;
        k--;
    }

      System.out.println(Arrays.toString(nums1));
        
        
    }
}
