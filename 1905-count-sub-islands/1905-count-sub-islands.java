class Solution 
{
    private int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int countSubIslands(int[][] grid1, int[][] grid2) 
    {
        int m = grid1.length;
        int n = grid1[0].length;
        int subIslands = 0;
        for (int i = 0; i < m; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                if (grid2[i][j] == 1)
                {
                    if (dfs(grid1, grid2, i, j))
                    {
                        subIslands++;
                    }
                }
            }
        }

        return subIslands;
        
    }
     private boolean dfs(int[][] grid1, int[][] grid2, int i, int j)
     {
        int m = grid1.length;
        int n = grid1[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || grid2[i][j] == 0) 
        {
            return true; 
        }

        grid2[i][j] = 0;

        boolean isSubIsland = true;
        for (int[] dir : dirs)
        {
            int ni = i + dir[0];
            int nj = j + dir[1];
            isSubIsland &= dfs(grid1, grid2, ni, nj);
        }

        return isSubIsland && grid1[i][j] == 1;
}
}