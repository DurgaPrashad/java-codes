class Solution {
    
    class DSU {
        int[] parent, rank;
        
        public DSU(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int u) {
            if (u != parent[u]) {
                parent[u] = find(parent[u]);
            }
            return parent[u];
        }
        
        public boolean union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);
            if (rootU == rootV) return false;  
            
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
            return true;
        }
    }
    
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU dsuAlice = new DSU(n + 1);
        DSU dsuBob = new DSU(n + 1);
        
        int edgesUsed = 0;
        
        
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (dsuAlice.union(edge[1], edge[2])) {
                    dsuBob.union(edge[1], edge[2]);
                    edgesUsed++;
                }
            }
        }
        
       
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (dsuAlice.union(edge[1], edge[2])) {
                    edgesUsed++;
                }
            } else if (edge[0] == 2) {
                if (dsuBob.union(edge[1], edge[2])) {
                    edgesUsed++;
                }
            }
        }
        
      
        int aliceRoot = dsuAlice.find(1);
        int bobRoot = dsuBob.find(1);
        for (int i = 2; i <= n; i++) {
            if (dsuAlice.find(i) != aliceRoot || dsuBob.find(i) != bobRoot) {
                return -1;
            }
        }
        
        return edges.length - edgesUsed;
    }
}
