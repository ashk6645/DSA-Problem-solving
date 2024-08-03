class Solution 
{
    public int coinChange(int[] coins, int amount)
    {
        if(amount == 0)
        {
            return 0;
        }
        if(coins ==  null || coins.length == 0)
        {
            return -1;
        }
        
        int max = amount+1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        
        for(int i=1; i<=amount;i++)
        {
            for(int coin : coins)
            {
                if(i>=coin)
                {
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}