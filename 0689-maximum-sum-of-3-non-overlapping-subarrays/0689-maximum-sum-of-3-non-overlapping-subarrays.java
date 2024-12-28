class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        
        // Calculate prefix sums
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        // Arrays to store the best indices for left, middle, and right subarrays
        int[] left = new int[n];
        int[] right = new int[n];

        // Compute the left best indices
        int maxSum = prefixSum[k] - prefixSum[0];
        left[k - 1] = 0;
        for (int i = k; i < n; i++) {
            int currentSum = prefixSum[i + 1] - prefixSum[i + 1 - k];
            if (currentSum > maxSum) {
                maxSum = currentSum;
                left[i] = i + 1 - k;
            } else {
                left[i] = left[i - 1];
            }
        }

        // Compute the right best indices
        maxSum = prefixSum[n] - prefixSum[n - k];
        right[n - k] = n - k;
        for (int i = n - k - 1; i >= 0; i--) {
            int currentSum = prefixSum[i + k] - prefixSum[i];
            if (currentSum >= maxSum) { // Choose lexicographically smallest
                maxSum = currentSum;
                right[i] = i;
            } else {
                right[i] = right[i + 1];
            }
        }

        int[] result = new int[3];
        maxSum = 0;
        for (int i = k; i <= n - 2 * k; i++) {
            int leftIndex = left[i - 1];
            int rightIndex = right[i + k];
            int currentSum = (prefixSum[leftIndex + k] - prefixSum[leftIndex]) +
                             (prefixSum[i + k] - prefixSum[i]) +
                             (prefixSum[rightIndex + k] - prefixSum[rightIndex]);

            if (currentSum > maxSum) {
                maxSum = currentSum;
                result[0] = leftIndex;
                result[1] = i;
                result[2] = rightIndex;
            }
        }

        return result;
    }
}