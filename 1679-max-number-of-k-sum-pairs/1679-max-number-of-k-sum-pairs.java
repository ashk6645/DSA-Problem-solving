class Solution 
{
    public int maxOperations(int[] nums, int k) 
    {
        Map<Integer, Integer> counts = new HashMap<>();
        int operations = 0;
        for(int num : nums)
        {
            if(counts.getOrDefault(k - num, 0)>0)
            {
                operations++;
                counts.put(k - num, counts.get(k-num)-1);
            }
            else
            {
                counts.put(num, counts.getOrDefault(num, 0)+1);
            }
        }
        return operations;
        
        
    }
}