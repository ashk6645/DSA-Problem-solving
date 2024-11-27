class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
         List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Initially, there is a unidirectional road from city i to city i + 1 for all 0 <= i < n - 1.
        for (int i = 0; i < n - 1; i++) {
            graph.get(i).add(new int[]{i + 1, 1});
        }
        
        int[] result = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int ui = query[0];
            int vi = query[1];
            
            // Add the new road from ui to vi
            graph.get(ui).add(new int[]{vi, 1});
            
            // Calculate the shortest path from city 0 to city n - 1
            result[i] = shortestPath(graph, n, 0, n - 1);
        }
        
        return result;
    }

    private int shortestPath(List<List<int[]>> graph, int n, int start, int end) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.offer(new int[]{start, 0});
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            int d = current[1];
            
            if (d > dist[u]) {
                continue;
            }
            
            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];
                int newDist = dist[u] + weight;
                
                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    pq.offer(new int[]{v, newDist});
                }
            }
        }
        
        return dist[end] == Integer.MAX_VALUE ? -1 : dist[end];
        
    }
}