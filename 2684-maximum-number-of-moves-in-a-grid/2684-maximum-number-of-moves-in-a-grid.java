class Solution {
    public int maxMoves(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        int[][] dp = new int[M][2];
        for (int i = 0; i < M; i++) {
            dp[i][0] = 1;
        }

        int maxMoves = 0;

        for (int j = 1; j < N; j++) {
            for (int i = 0; i < M; i++) {
               
                if (grid[i][j] > grid[i][j - 1] && dp[i][0] > 0) {
                    dp[i][1] = Math.max(dp[i][1], dp[i][0] + 1);
                }
             
                if (i - 1 >= 0 && grid[i][j] > grid[i - 1][j - 1] && dp[i - 1][0] > 0) {
                    dp[i][1] = Math.max(dp[i][1], dp[i - 1][0] + 1);
                }
              
                if (i + 1 < M && grid[i][j] > grid[i + 1][j - 1] && dp[i + 1][0] > 0) {
                    dp[i][1] = Math.max(dp[i][1], dp[i + 1][0] + 1);
                }
                maxMoves = Math.max(maxMoves, dp[i][1] - 1);
            }
            for (int k = 0; k < M; k++) {
                dp[k][0] = dp[k][1];
                dp[k][1] = 0;
            }
        }
        return maxMoves;
    }
}