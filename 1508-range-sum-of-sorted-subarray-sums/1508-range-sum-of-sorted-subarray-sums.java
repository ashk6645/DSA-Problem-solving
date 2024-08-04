class Solution
{
    private static final int MOD = 1_000_000_007;
    public int rangeSum(int[] nums, int n, int left, int right) 
    {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        long[] prefixSum = new long[n + 1];
        
        for (int i = 0; i < n; i++)
        {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        for (int i = 0; i < n; i++) 
        {
            for (int j = i; j < n; j++)
            {
                long sum = prefixSum[j + 1] - prefixSum[i];
                minHeap.offer(sum);
            }
        }
        
        long result = 0;
        for (int i = 1; i <= right; i++)
        {
            if (i >= left)
            {
                result = (result + minHeap.poll()) % MOD;
            }
            else
            {
                minHeap.poll();
            }
        }
        
        return (int) result;     
    }
}