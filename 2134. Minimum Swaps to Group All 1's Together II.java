class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int totalOnes = 0;

        for (int num : nums) {
            totalOnes += num;
        }

    
        if (totalOnes == 0) {
            return 0;
        }

      
        int currentOnes = 0;
        int maxOnesInWindow = 0;

   
        for (int i = 0; i < totalOnes; i++) {
            currentOnes += nums[i];
        }

        maxOnesInWindow = currentOnes;

 
        for (int i = totalOnes; i < n + totalOnes; i++) {
            currentOnes += nums[i % n] - nums[i - totalOnes];
            maxOnesInWindow = Math.max(maxOnesInWindow, currentOnes);
        }

        return totalOnes - maxOnesInWindow;
    }
}
