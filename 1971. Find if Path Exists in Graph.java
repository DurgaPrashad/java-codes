import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Create an adjacency list to represent the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        
        // Use DFS to check if a valid path exists from source to destination
        boolean[] visited = new boolean[n];
        return dfs(graph, visited, source, destination);
    }
    
    private boolean dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int current, int destination) {
        if (current == destination) {
            return true; // Found a path to the destination
        }
        
        visited[current] = true;
        
        // Explore all neighbors of the current node
        if (graph.containsKey(current)) {
            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor] && dfs(graph, visited, neighbor, destination)) {
                    return true; // If a path is found from any neighbor to destination
                }
            }
        }
        
        return false; // No path found from this node to destination
    }
}
