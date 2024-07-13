import java.util.*;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<int[]> robots = new ArrayList<>();
        
       
        for (int i = 0; i < n; i++) {
            robots.add(new int[]{positions[i], healths[i], directions.charAt(i), i});
        }
        
        robots.sort(Comparator.comparingInt(a -> a[0]));
       
        Deque<int[]> stack = new ArrayDeque<>();
        int[] result = new int[n];
        Arrays.fill(result, -1);
        
        for (int[] robot : robots) {
            int position = robot[0];
            int health = robot[1];
            char direction = (char) robot[2];
            int index = robot[3];
            
            if (direction == 'R') {
                stack.push(robot);
            } else {
                while (!stack.isEmpty() && health > 0) {
                    int[] top = stack.peek();
                    
                    if (top[1] < health) {
                        stack.pop();
                        health--;
                    } else if (top[1] > health) {
                        top[1]--;
                        health = 0;
                    } else {
                        stack.pop();
                        health = 0;
                    }
                }
                
                if (health > 0) {
                    result[index] = health;
                }
            }
        }
        
        while (!stack.isEmpty()) {
            int[] robot = stack.pop();
            result[robot[3]] = robot[1];
        }
        
        List<Integer> survived = new ArrayList<>();
        for (int h : result) {
            if (h != -1) {
                survived.add(h);
            }
        }
        
        return survived;
    }
}
