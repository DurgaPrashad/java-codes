import java.util.*;

class Solution {
    Map<Integer, List<Integer>> graph;
    int[] count;
    int[] ans;
    int N;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        N = n;
        graph = new HashMap<>();
        count = new int[n];
        ans = new int[n];

        // Build the graph
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(0, -1);
        dfs2(0, -1);

        return ans;
    }

    // First dfs to calculate counts of children and distance sum of children from current node
    private void dfs(int node, int parent) {
        for (int child : graph.getOrDefault(node, new ArrayList<>())) {
            if (child == parent) continue;
            dfs(child, node);
            count[node] += count[child];
            ans[node] += ans[child] + count[child];
        }
        count[node]++;
    }

    // Second dfs to update answer for each node using the answer of its parent
    private void dfs2(int node, int parent) {
        for (int child : graph.getOrDefault(node, new ArrayList<>())) {
            if (child == parent) continue;
            ans[child] = ans[node] - count[child] + N - count[child];
            dfs2(child, node);
        }
    }
}
