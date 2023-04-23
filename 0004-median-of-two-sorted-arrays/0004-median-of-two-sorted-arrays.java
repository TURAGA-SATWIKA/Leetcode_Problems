class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
    
    if (n1 > n2) {
        // ensure that nums1 is smaller array
        return findMedianSortedArrays(nums2, nums1);
    }
    
    int left = 0, right = n1;
    int mid1 = 0, mid2 = 0;
    
    while (left <= right) {
        mid1 = (left + right) / 2;
        mid2 = (n1 + n2 + 1) / 2 - mid1;
        
        int maxLeft1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
        int minRight1 = (mid1 == n1) ? Integer.MAX_VALUE : nums1[mid1];
        
        int maxLeft2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
        int minRight2 = (mid2 == n2) ? Integer.MAX_VALUE : nums2[mid2];
        
        if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
            // found the correct partition
            if ((n1 + n2) % 2 == 0) {
                // even number of elements
                return (double) (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2;
            } else {
                // odd number of elements
                return (double) Math.max(maxLeft1, maxLeft2);
            }
        } else if (maxLeft1 > minRight2) {
            // move left in nums1
            right = mid1 - 1;
        } else {
            // move right in nums1
            left = mid1 + 1;
        }
    }
    
    // should never reach here
    return 0.0;
        
    }
}