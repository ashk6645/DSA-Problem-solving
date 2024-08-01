class Solution 
{
    public int countSeniors(String[] details)
    {
        int ans = 0;
        for(String detail:details)
        {
            if ((detail.charAt(11) - '0') * 10 + (detail.charAt(12) - '0') > 60) 
            {
                ans++;
            }
        }
        return ans;
        
    }
}