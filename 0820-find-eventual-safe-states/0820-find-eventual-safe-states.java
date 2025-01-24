class Solution {
    public boolean dfs(int node, int[][] adj, boolean[] visit, boolean[] inStack){
        if(inStack[node]){
            return true;
        }
        if(visit[node]){
            return false;
        }
        visit[node] = true;
        inStack[node] = true;
        for(int neighbour : adj[node]){
            if(dfs(neighbour, adj, visit, inStack)){
                return true;
            }
        }
        inStack[node] = false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] visit = new boolean[n];
        boolean[] inStack = new boolean[n];
        for(int i=0;i<n;i++){
            dfs(i,graph,visit, inStack);
        }
        List<Integer> safeNodes = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!inStack[i]){
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }
}