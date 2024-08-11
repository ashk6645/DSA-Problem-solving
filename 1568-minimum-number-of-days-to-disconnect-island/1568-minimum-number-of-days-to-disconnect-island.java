class Solution 
{
    private static final int[] dirX = {0,0,1,-1};
    private static final int[] dirY = {1,-1,0,0};
    public int minDays(int[][] grid)
    {
        if(!isConnected(grid))
        {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i=0;i<rows;++i)
        {
            for(int j=0;j<cols;++j)
            {
                if(grid[i][j] == 1)
                {
                    grid[i][j] = 0; //Change land to water
                    if(!isConnected(grid))
                    {
                        return 1;
                    }
                    grid[i][j] = 1; //Revert back
                }
                
            }
        }
        return 2;  //if still connected
    }
    private boolean isConnected(int[][] grid)
    {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int components = 0;
        for(int i=0;i<rows;++i)
        {
            for(int j=0;j<cols;++j)
            {
                if(grid[i][j] == 1 && !visited[i][j])
                {
                    if (++components > 1)
                    {
                        return false;
                    }
                    dfs(grid, visited, i, j);
                }
            }
        }
        return components == 1;
    }
    private void dfs(int[][] grid, boolean[][] visited, int x, int y)
    {
        visited[x][y] = true;
        int rows = grid.length;
        int cols = grid[0].length;
        for(int d=0; d<4;++d)
        {
            int nx = x + dirX[d]; 
            int ny = y + dirY[d];
            if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && grid[nx][ny] == 1 && !visited[nx][ny])
            {
                dfs(grid, visited, nx, ny);
            }
        }
    }
    
}