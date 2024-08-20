class Solution 
{
    public int stoneGameII(int[] piles)
    {
         int n = piles.length;
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) 
        {
            Arrays.fill(row, -1);
        }
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) 
        {
            suffixSum[i] = piles[i] + suffixSum[i + 1];
        }
        return helper(0, 1, piles, dp, suffixSum);
    }
     private int helper(int i, int M, int[] piles, int[][] dp, int[] suffixSum)
     {
        if (i == piles.length)
        {
            return 0;
        }
        if (dp[i][M] != -1)
        {
            return dp[i][M];
        }
        int maxStones = 0;
        for (int x = 1; x <= 2 * M && i + x <= piles.length; x++)
        {
            int opponent = helper(i + x, Math.max(M, x), piles, dp, suffixSum);
            maxStones = Math.max(maxStones, suffixSum[i] - opponent);
        }
        dp[i][M] = maxStones;
        return maxStones;
    }
}