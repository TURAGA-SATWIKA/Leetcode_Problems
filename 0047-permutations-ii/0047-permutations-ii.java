class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> seen = new HashSet<>();
        permute(nums, 0, result, seen);
        return result;
    }
    
    private void permute(int[] nums, int start, List<List<Integer>> result, Set<List<Integer>> seen) {
        if (start == nums.length) {
            List<Integer> perm = new ArrayList<>();
            for (int num : nums) {
                perm.add(num);
            }
            if (!seen.contains(perm)) {
                result.add(perm);
                seen.add(perm);
            }
        } else {
            for (int i = start; i < nums.length; i++) {
                swap(nums, start, i);
                permute(nums, start + 1, result, seen);
                swap(nums, start, i);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}