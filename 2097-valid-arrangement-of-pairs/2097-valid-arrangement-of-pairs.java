class Solution {

    public int[][] validArrangement(int[][] pairs) {
        HashMap<Integer, LinkedList<Integer>> adjacencyMatrix = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>(), outDegree =
        new HashMap<>();

        for (int[] pair : pairs) {
            int start = pair[0], end = pair[1];
            adjacencyMatrix.putIfAbsent(start, new LinkedList<>());
            adjacencyMatrix.get(start).add(end);
            outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);
            inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);
        }

        ArrayList<Integer> result = new ArrayList<>();

        int startNode = -1;
        for (int node : outDegree.keySet()) {
            if (outDegree.get(node) == inDegree.getOrDefault(node, 0) + 1) {
                startNode = node;
                break;
            }
        }

        if (startNode == -1) {
            startNode = pairs[0][0];
        }

        Stack<Integer> nodeStack = new Stack<>();
        nodeStack.push(startNode);

        while (!nodeStack.empty()) {
            int node = nodeStack.peek();
            if (adjacencyMatrix.getOrDefault(node, new LinkedList<>()).size() > 0) {
                int nextNode = adjacencyMatrix.get(node).removeFirst();
                nodeStack.push(nextNode);
            } else {
                result.add(node);
                nodeStack.pop();
            }
        }
        Collections.reverse(result);
        int[][] pairedResult = new int[result.size() - 1][2];
        for (int i = 1; i < result.size(); ++i) {
            pairedResult[i - 1][0] = result.get(i - 1);
            pairedResult[i - 1][1] = result.get(i);
        }

        return pairedResult;
    }
}