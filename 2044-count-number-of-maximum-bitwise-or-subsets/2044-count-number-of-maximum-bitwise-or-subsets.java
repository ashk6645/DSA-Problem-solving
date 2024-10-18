class Solution
{
    public int countMaxOrSubsets(int[] nums) 
    {
        int maxOrValue = 0;
        for (int num : nums) 
        {
            maxOrValue |= num;
        }

        int[] dp = new int[1 << 17];
        dp[0] = 1; 

        // Populate the DP array
        for (int num : nums) 
        {
            for (int i = maxOrValue; i >= 0; i--) 
            {
                dp[i | num] += dp[i]; 
            }
            maxOrValue |= num; 
        }

        return dp[maxOrValue];
        
    }
}