class Solution 
{
    public int strangePrinter(String s) 
    {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int len=1; len<=n; len++)
        {
            for (int i = 0; i + len - 1 < n; i++) 
            {
                int j = i + len - 1;
                dp[i][j] = len == 1 ? 1 : dp[i + 1][j] + 1;
                for (int k = i + 1; k <= j; k++) 
                {
                    if (s.charAt(k) == s.charAt(i)) 
                    {
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][k - 1] + dp[k][j]);
                    }
            }
        }
    }
        return dp[0][n-1];
 }
}