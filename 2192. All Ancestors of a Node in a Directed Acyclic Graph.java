import java.util.*;

class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[1]).add(edge[0]);
        }

        List<Set<Integer>> ancestors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ancestors.add(new HashSet<>());
        }

        for (int i = 0; i < n; i++) {
            dfs(i, graph, ancestors);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> sortedAncestors = new ArrayList<>(ancestors.get(i));
            Collections.sort(sortedAncestors);
            result.add(sortedAncestors);
        }
        
        return result;
    }

    private void dfs(int node, List<List<Integer>> graph, List<Set<Integer>> ancestors) {
        for (int parent : graph.get(node)) {
            if (ancestors.get(node).add(parent)) {
                dfs(parent, graph, ancestors);
                ancestors.get(node).addAll(ancestors.get(parent));
            }
        }
    }
}
