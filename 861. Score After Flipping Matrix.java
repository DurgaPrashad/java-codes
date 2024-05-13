class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                toggleRow(grid, i);
            }
        }
        
        for (int j = 1; j < n; j++) {
            int countOnes = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    countOnes++;
                }
            }
            if (countOnes < (m + 1) / 2) {
                toggleColumn(grid, j);
            }
        }
        
        int score = 0;
        for (int i = 0; i < m; i++) {
            int rowScore = 0;
            for (int j = 0; j < n; j++) {
                rowScore = (rowScore << 1) + grid[i][j];
            }
            score += rowScore;
        }
        
        return score;
    }
    
    private void toggleRow(int[][] grid, int row) {
        for (int j = 0; j < grid[row].length; j++) {
            grid[row][j] = 1 - grid[row][j];
        }
    }
    
    private void toggleColumn(int[][] grid, int col) {
        for (int i = 0; i < grid.length; i++) {
            grid[i][col] = 1 - grid[i][col];
        }
    }
}
