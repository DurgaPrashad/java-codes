class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(nums, 0, 0);
    }
    
    private int helper(int[] nums, int index, int currentXOR) {
        // Base case: if we've processed all elements
        if (index == nums.length) {
            return currentXOR;
        }
        
        // Recursive case: sum of XOR totals including and excluding the current element
        int includeCurrent = helper(nums, index + 1, currentXOR ^ nums[index]);
        int excludeCurrent = helper(nums, index + 1, currentXOR);
        
        return includeCurrent + excludeCurrent;
    }
}
