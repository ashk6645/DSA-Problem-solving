class Solution {
    public int shortestSubarray(int[] nums, int k) {
          int n = nums.length;

        // Size is n+1 to handle subarrays starting from index 0
        long[] prefixSums = new long[n + 1];

        // Calculate prefix sums
        for (int i = 1; i <= n; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i - 1];
        }

        Deque<Integer> candidateIndices = new ArrayDeque<>();

        int shortestSubarrayLength = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            // Remove candidates from front of deque where subarray sum meets target
            while (
                !candidateIndices.isEmpty() &&
                prefixSums[i] - prefixSums[candidateIndices.peekFirst()] >=
                k
            ) {
                // Update shortest subarray length
                shortestSubarrayLength = Math.min(
                    shortestSubarrayLength,
                    i - candidateIndices.pollFirst()
                );
            }

            while (!candidateIndices.isEmpty() && prefixSums[i] <= prefixSums[candidateIndices.peekLast()])
                
               
             {
                candidateIndices.pollLast();
            }

            candidateIndices.offerLast(i);
        }

        return shortestSubarrayLength == Integer.MAX_VALUE ? -1 : shortestSubarrayLength;
        
    }
}