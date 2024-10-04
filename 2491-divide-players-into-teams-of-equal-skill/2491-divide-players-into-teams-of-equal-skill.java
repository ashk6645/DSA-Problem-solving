class Solution 
{
    public long dividePlayers(int[] skill)
    {
        
        int n = skill.length;
        Arrays.sort(skill);

        long sum = 0;
        long chemistry = 0;
        
        for (int i = 0; i < n / 2; i++) 
        {
            int pairSum = skill[i] + skill[n - i - 1];
            if (i == 0) 
            {
                sum = pairSum;
            }
            else if (pairSum != sum) 
            {
                return -1;
            }
            chemistry += skill[i] * skill[n - i - 1];
        }

        return chemistry;
        
    }
}