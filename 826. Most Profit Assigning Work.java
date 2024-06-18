import java.util.Arrays;

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int m = worker.length;
        
     
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        Arrays.sort(worker);
        
        int maxProfit = 0;
        int totalProfit = 0;
        int jobIndex = 0;
        
    
        for (int i = 0; i < m; i++) {
          
            while (jobIndex < n && worker[i] >= jobs[jobIndex][0]) {
                maxProfit = Math.max(maxProfit, jobs[jobIndex][1]);
                jobIndex++;
            }
           
            totalProfit += maxProfit;
        }
        
        return totalProfit;
    }
}
