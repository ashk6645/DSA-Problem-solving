class Solution
{
   
    public int rangeSum(int[] nums, int n, int left, int right) 
    {
        List<Integer> subSum = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            int sum = 0;
            for (int j = i; j < n; j++)
            {
                sum += nums[j];
                subSum.add(sum);
            }
        }
        
        Collections.sort(subSum);
        long result = 0;
        for (int i = left - 1; i < right; i++)
        {
            result += subSum.get(i);
        }
        
        return (int) (result % 1000000007);   
    }
}