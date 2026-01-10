class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

       // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n1 = nums1.length;
        int n2 = nums2.length;

        int low = 0;
        int high = n1;

        while (low <= high) {

            int i = (low + high) / 2;
            int j = (n1 + n2 + 1) / 2 - i;

            int maxLeft1;
            int minRight1;
            int maxLeft2;
            int minRight2;

            // nums1 left
            if (i == 0) {
                maxLeft1 = Integer.MIN_VALUE;
            } else {
                maxLeft1 = nums1[i - 1];
            }

            // nums1 right
            if (i == n1) {
                minRight1 = Integer.MAX_VALUE;
            } else {
                minRight1 = nums1[i];
            }

            // nums2 left
            if (j == 0) {
                maxLeft2 = Integer.MIN_VALUE;
            } else {
                maxLeft2 = nums2[j - 1];
            }

            // nums2 right
            if (j == n2) {
                minRight2 = Integer.MAX_VALUE;
            } else {
                minRight2 = nums2[j];
            }

            // Check if partition is valid
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {

                // Odd total length
                if ((n1 + n2) % 2 == 1) {
                    return Math.max(maxLeft1, maxLeft2);
                }
                // Even total length
                else {
                    return (Math.max(maxLeft1, maxLeft2)
                          + Math.min(minRight1, minRight2)) / 2.0;
                }
            }

            // Move partition
            else if (maxLeft1 > minRight2) {
                high = i - 1;
            } else {
                low = i + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays not sorted");
        

        
    }
}