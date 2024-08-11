class Solution
{
    private static final int[] dirX = {0, 0, 1, -1};
    private static final int[] dirY = {1, -1, 0, 0};

    public int minDays(int[][] grid) 
    {
        int rows = grid.length, cols = grid[0].length;
        int landCount = 0;
        for (int i = 0; i < rows; ++i)
        {
            for (int j = 0; j < cols; ++j) 
            {
                if (grid[i][j] == 1)
                {
                    landCount++;
                }
            }
        }
        if (landCount == 1) 
        {
            return 1;
        }
        if (!isConnected(grid, rows, cols)) 
        {
            return 0;
        }
        for (int i = 0; i < rows; ++i)
        {
            for (int j = 0; j < cols; ++j)
            {
                if (grid[i][j] == 1)
                {
                    grid[i][j] = 0; // Change land to water
                    if (!isConnected(grid, rows, cols))
                    {
                        return 1; 
                    }
                       
                    grid[i][j] = 1; // Revert back
                }
            }
        }

        // If still connected, return 2
        return 2;
    }

    private boolean isConnected(int[][] grid, int rows, int cols)
    {
        boolean[][] visited = new boolean[rows][cols];
        boolean foundIsland = false;

        for (int i = 0; i < rows; ++i) 
        {
            for (int j = 0; j < cols; ++j)
            {
                if (grid[i][j] == 1 && !visited[i][j]) 
                {
                    if (foundIsland)
                    {
                        return false; 
                    }
                    dfs(grid, visited, i, j, rows, cols);
                    foundIsland = true;
                }
            }
        }

        return foundIsland;
    }

    private void dfs(int[][] grid, boolean[][] visited, int x, int y, int rows, int cols)
    {
        visited[x][y] = true;
        for (int d = 0; d < 4; ++d)
        {
            int nx = x + dirX[d], ny = y + dirY[d];
            if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && grid[nx][ny] == 1 && !visited[nx][ny])             {
                dfs(grid, visited, nx, ny, rows, cols);
            }
        }
    }
}
