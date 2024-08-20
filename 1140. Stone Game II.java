class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] prefixSum = new int[n + 1];
        
        // Compute prefix sums
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + piles[i];
        }
        

        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return dfs(0, 1, piles, prefixSum, dp);
    }
    
    private int dfs(int index, int M, int[] piles, int[] prefixSum, int[][] dp) {
        int n = piles.length;
        if (index >= n) {
            return 0;
        }
        if (dp[index][M] != -1) {
            return dp[index][M];
        }
        
        int maxStones = 0;
        int totalStones = 0;
        
        for (int X = 1; X <= 2 * M && index + X <= n; X++) {
            totalStones += piles[index + X - 1];
            int stonesTakenByAlice = totalStones + (prefixSum[n] - prefixSum[index + X] - dfs(index + X, Math.max(M, X), piles, prefixSum, dp));
            maxStones = Math.max(maxStones, stonesTakenByAlice);
        }
        
        dp[index][M] = maxStones;
        return maxStones;
    }
}
