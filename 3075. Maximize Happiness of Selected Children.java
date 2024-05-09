import java.util.Arrays;

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        long totalHappiness = 0;
        
        Arrays.sort(happiness);
        for (int i = n - 1; i >= 0 && k > 0; i--) {
            totalHappiness += happiness[i];
            k--;
            for (int j = 0; j < i; j++) {
                if (happiness[j] > 0) {
                    happiness[j]--;
                }
            }
        }
        
        return totalHappiness;
    }
}
