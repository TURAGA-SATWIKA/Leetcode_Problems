class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] candidates, int remaining, int start) {
        if (remaining == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            int num = candidates[i];
            if (num <= remaining) {
                temp.add(num);
                backtrack(result, temp, candidates, remaining - num, i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}