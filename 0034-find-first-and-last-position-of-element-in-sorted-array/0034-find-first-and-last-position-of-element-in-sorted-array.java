class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int left = 0, right = nums.length - 1;
        
        // Find left bound of target element
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                result[0] = mid;
                right = mid - 1;
            }
        }
        
        // If target element not found, return [-1, -1]
        if (result[0] == -1) {
            return result;
        }
        
        left = result[0];
        right = nums.length - 1;
        
        // Find right bound of target element
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                result[1] = mid;
                left = mid + 1;
            }
        }
        
        return result;
    }
}