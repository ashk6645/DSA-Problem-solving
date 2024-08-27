class Solution
{
    static class Node 
    {
        int vertex;
        double probability;
        
        Node(int vertex, double probability)
        {
            this.vertex = vertex;
            this.probability = probability;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node)
    {
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            graph.get(u).add(new Node(v, prob));
            graph.get(v).add(new Node(u, prob));
        }
        
        // Use a priority queue to store the maximum probability path
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Double.compare(b.probability, a.probability));
        double[] dist = new double[n];
        dist[start_node] = 1.0;
        pq.add(new Node(start_node, 1.0));
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;
            double prob = current.probability;
            
            if (u == end_node) {
                return prob;
            }
            
            for (Node neighbor : graph.get(u)) {
                int v = neighbor.vertex;
                double edgeProb = neighbor.probability;
                
                if (dist[u] * edgeProb > dist[v]) {
                    dist[v] = dist[u] * edgeProb;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }
        
        return 0.0;
        
    }
}