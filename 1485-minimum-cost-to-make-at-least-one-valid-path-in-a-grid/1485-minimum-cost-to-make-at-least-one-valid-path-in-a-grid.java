class Solution {
    public int minCost(int[][] grid) {
         int numRows = grid.length;
        int numCols = grid[0].length;
        boolean[][] visited = new boolean[numRows][numCols];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0, 0});
        int[][] directions = {{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
      
        // BFS starts here
        while (!queue.isEmpty()) {
            // Dequeue a cell info from the queue.
            int[] position = queue.poll();
            int i = position[0], j = position[1], cost = position[2];
            if (i == numRows - 1 && j == numCols - 1) {
                return cost;
            }
            if (visited[i][j]) {
                continue;
            }
            visited[i][j] = true;
            for (int k = 1; k <= 4; ++k) {
                int newX = i + directions[k][0], newY = j + directions[k][1];
                if (newX >= 0 && newX < numRows && newY >= 0 && newY < numCols) {
                    if (grid[i][j] == k) {
                        queue.offerFirst(new int[] {newX, newY, cost});
                    } else {
                        queue.offer(new int[] {newX, newY, cost + 1});
                    }
                }
            }
        }
        return -1;
    }
}