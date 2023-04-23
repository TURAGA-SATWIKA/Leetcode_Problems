class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
int start = 0, end = n - 1;
        while (start <= end) {
        int mid = start + (end - start) / 2;

        if (nums[mid] == target)
            return mid;

        if (nums[start] <= nums[mid]) { // left half is sorted
            if (nums[start] <= target && target < nums[mid])
                end = mid - 1; // target in left half
            else
                start = mid + 1; // target in right half
        } else { // right half is sorted
            if (nums[mid] < target && target <= nums[end])
                start = mid + 1; // target in right half
            else
                end = mid - 1; // target in left half
        }
    }

    return -1;
    }
}