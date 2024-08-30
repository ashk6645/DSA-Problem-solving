class Solution
{
   public static final int MAX_DISTANCE = 2000000000;
    public static final int[][] IMPOSSIBLE_RESULT = new int[0][0];

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        GraphNode shortestPath = calculateShortestPath(edges, source, destination);
        if (shortestPath == null || shortestPath.distance > target) {
            return IMPOSSIBLE_RESULT;
        } else {
            int[][] results;
            do {
                results = replaceWildcards(shortestPath, edges, target);
                //verify that -1 replaced correctly and shortestPath distance not changed after replacement
                shortestPath = calculateShortestPath(results, source, destination);
            } while (results.length > 0 && shortestPath.distance != target);
            return results;
        }
    }

    private GraphNode calculateShortestPath(int[][] edges, int start, int end) {
        Map<Integer, List<int[]>> graph = buildGraph(edges);
        return dijkstra(graph, start, end);
    }

    private GraphNode dijkstra(Map<Integer, List<int[]>> graph, int start, int end) {
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<GraphNode> pq = new PriorityQueue<>(Comparator.comparingInt(value -> value.distance));
        pq.add(new GraphNode(start, 0, new int[]{start}));
        while (!pq.isEmpty()) {
            GraphNode current = pq.poll();
            List<int[]> neighbors = Objects.requireNonNullElse(graph.get(current.vertex), Collections.emptyList());
            if (current.vertex == end) {
                return current;
            }
            for (int[] neighbor : neighbors) {
                if (!visited.contains(neighbor[0])) {
                    //count distance -1 as minimal value (1) - Math.abs(neighbor[1])
                    pq.add(new GraphNode(neighbor[0], current.distance + Math.abs(neighbor[1]), addValueToArray(current.path, neighbor[0])));
                }
            }
            visited.add(current.vertex);
        }
        return null;
    }

    //replace -1 to MAX_DISTANCE, if it not in the shortestPath
    //replace -1 to 1, if it in the shortestPath, but not the first
    //replace -1 to 1 + diff, if it in the shortestPath and it's the first
    //if diff(shortestPath diff to target) > 0 and shortestPath not contains -1, return IMPOSSIBLE_RESULT
    private int[][] replaceWildcards(GraphNode end, int[][] edges, int target) {
        int diff = target - end.distance;
        Set<Pair<Integer, Integer>> path = new HashSet<>();
        for (int i = 1; i < end.path.length; i++) {
            path.add(new Pair<>(end.path[i - 1], end.path[i]));
        }
        int[][] edgesCopy = copy2DArray(edges);
        for (int[] edge : edgesCopy) {
            if (edge[2] == -1) {
                if (path.contains(new Pair<>(edge[0], edge[1])) || path.contains(new Pair<>(edge[1], edge[0]))) {
                    edge[2] = 1 + diff;
                    diff = 0;
                } else {
                    edge[2] = MAX_DISTANCE;
                }
            }
        }
        if (diff == 0) {
            return edgesCopy;
        } else return IMPOSSIBLE_RESULT;
    }

    private int[] addValueToArray(int[] array, int last) {
        int[] result = Arrays.copyOf(array, array.length + 1);
        result[result.length - 1] = last;
        return result;
    }

    private Map<Integer, List<int[]>> buildGraph(int[][] edges) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new int[]{edge[0], edge[2]});
        }
        return graph;
    }

    private int[][] copy2DArray(int[][] edges) {
        int[][] edgesCopy = new int[edges.length][edges[0].length];
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                edgesCopy[i][j] = edges[i][j];
            }
        }
        return edgesCopy;
    }

    private record GraphNode(int vertex, int distance, int[] path) {}
}