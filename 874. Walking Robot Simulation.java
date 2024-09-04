import java.util.HashSet;
import java.util.Set;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // Directions represent the change in x and y coordinates for north, east, south, and west
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0, directionIndex = 0;
        int maxDistanceSquared = 0;
        
        // Convert obstacles array to a set of strings to allow fast lookup
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        // Process each command
        for (int command : commands) {
            if (command == -2) { // Turn left
                directionIndex = (directionIndex + 3) % 4;
            } else if (command == -1) { // Turn right
                directionIndex = (directionIndex + 1) % 4;
            } else { // Move forward k units
                for (int i = 0; i < command; i++) {
                    int nextX = x + directions[directionIndex][0];
                    int nextY = y + directions[directionIndex][1];
                    
                    // Check if the next position is an obstacle
                    if (obstacleSet.contains(nextX + "," + nextY)) {
                        break; // Stop moving in this direction if an obstacle is encountered
                    }
                    
                    x = nextX;
                    y = nextY;
                    maxDistanceSquared = Math.max(maxDistanceSquared, x * x + y * y);
                }
            }
        }
        
        return maxDistanceSquared;
    }
}
