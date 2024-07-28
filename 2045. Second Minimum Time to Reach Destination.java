import java.util.*;

class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        // Graph adjacency list representation
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        // Priority queue for BFS: (current time, current vertex, visits to the vertex)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 1, 0}); // Starting from vertex 1 at time 0 with 0 visits
        
        int[][] times = new int[n + 1][2]; // Track two smallest times to reach each vertex
        for (int i = 0; i <= n; i++) {
            Arrays.fill(times[i], Integer.MAX_VALUE);
        }
        times[1][0] = 0; // First time to reach vertex 1 is 0
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentTime = current[0], currentNode = current[1], visits = current[2];
            
            // Traverse all neighboring vertices
            for (int neighbor : graph.get(currentNode)) {
                int arrivalTime = currentTime + time;
                int waitTime = 0;
                // Determine if waiting is required due to traffic signals
                if ((arrivalTime / change) % 2 == 1) {
                    waitTime = change - (arrivalTime % change);
                }
                int newTime = arrivalTime + waitTime;
                
                // Check the first and second minimum times
                if (newTime < times[neighbor][0]) {
                    times[neighbor][1] = times[neighbor][0];
                    times[neighbor][0] = newTime;
                    pq.offer(new int[]{newTime, neighbor, visits + 1});
                } else if (newTime > times[neighbor][0] && newTime < times[neighbor][1]) {
                    times[neighbor][1] = newTime;
                    pq.offer(new int[]{newTime, neighbor, visits + 1});
                }
            }
        }
        
        return times[n][1]; // The second minimum time to reach vertex n
    }
}
