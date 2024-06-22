class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int[] prefixCount = new int[nums.length + 1];
        prefixCount[0] = 1;
        
        int oddCount = 0;
        int result = 0;
        
        for (int num : nums) {
            if (num % 2 != 0) {
                oddCount++;
            }
            
            if (oddCount >= k) {
                result += prefixCount[oddCount - k];
            }
            
            prefixCount[oddCount]++;
        }
        
        return result;
    }
}
