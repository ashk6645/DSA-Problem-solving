class Solution
{
    public long maxPoints(int[][] points)
    {
        int m = points.length;
        int n = points[0].length;
        long[][] dp = new long[m][n];

        for (int j = 0; j < n; j++)
        {
            dp[0][j] = points[0][j];
        }

        for (int i = 1; i < m; i++)
        {
            long[] left = new long[n];
            long[] right = new long[n];
            left[0] = dp[i - 1][0];
            right[n - 1] = dp[i - 1][n - 1];
            for (int j = 1; j < n; j++) 
            {
                left[j] = Math.max(left[j - 1] - 1, dp[i - 1][j]);
                right[n - j - 1] = Math.max(right[n - j] - 1, dp[i - 1][n - j - 1]);
            }
            for (int j = 0; j < n; j++)
            {
                dp[i][j] = points[i][j] + Math.max(left[j], right[j]);
            }
        }
        long max = Long.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            max = Math.max(max, dp[m - 1][j]);
        }
        return max;
    }
}