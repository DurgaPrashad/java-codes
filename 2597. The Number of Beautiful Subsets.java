class Solution {
    private int count = 0;

    public int beautifulSubsets(int[] nums, int k) {
        backtrack(nums, k, 0, new ArrayList<>());
        return count;
    }
    
    private void backtrack(int[] nums, int k, int start, List<Integer> currentSubset) {
        // We start from start index to avoid duplicate subsets
        if (!currentSubset.isEmpty()) {
            count++;
        }
        
        for (int i = start; i < nums.length; i++) {
            if (canAdd(nums[i], currentSubset, k)) {
                currentSubset.add(nums[i]);
                backtrack(nums, k, i + 1, currentSubset);
                currentSubset.remove(currentSubset.size() - 1);
            }
        }
    }
    
    private boolean canAdd(int num, List<Integer> currentSubset, int k) {
        for (int n : currentSubset) {
            if (Math.abs(n - num) == k) {
                return false;
            }
        }
        return true;
    }
}
