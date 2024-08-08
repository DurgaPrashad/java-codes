class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int totalCells = rows * cols;
        int[][] result = new int[totalCells][2];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; 
        int dir = 0; 
        int r = rStart, c = cStart;
        int steps = 1;
        int index = 0;
        
        result[index++] = new int[]{r, c};
        
        while (index < totalCells) {
            for (int i = 0; i < steps; i++) {
                r += directions[dir][0];
                c += directions[dir][1];
                if (isValid(r, c, rows, cols)) {
                    result[index++] = new int[]{r, c};
                }
            }
            dir = (dir + 1) % 4; 
            if (dir % 2 == 0) {
                steps++; 
            }
        }
        
        return result;
    }
    
    private boolean isValid(int r, int c, int rows, int cols) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }
}
