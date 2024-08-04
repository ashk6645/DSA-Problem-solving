class Solution
{
    private static final int MOD = 1_000_000_007;
   
    public int rangeSum(int[] nums, int n, int left, int right) 
    {
       PriorityQueue<Long> minHeap = new PriorityQueue<>();
        long result = 0;

        // Compute all subarray sums
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                minHeap.offer(sum);
            }
        }

        // Extract the sums from left to right
        for (int i = 1; i <= right; i++) {
            long currentSum = minHeap.poll();
            if (i >= left) {
                result = (result + currentSum) % MOD;
            }
        }

        return (int) result;
    }
}