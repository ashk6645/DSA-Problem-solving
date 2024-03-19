class Solution
{
    public int leastInterval(char[] tasks, int n) 
    {
        int[] freq = new int[26];
        for(char ch : tasks)
        {
            freq[ch-'A']++;
        }
         Arrays.sort(freq); 
        
        int maxFreq = freq[25] - 1; 
        int idleSlots = maxFreq * n;
        
        for (int i = 24; i >= 0 && freq[i] > 0; i--)
        {
            idleSlots -= Math.min(freq[i], maxFreq); 
        }
       
        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }
}