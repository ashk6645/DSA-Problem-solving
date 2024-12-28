// class Solution {
//     public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
//         int n = nums.length;
//         int[] prefixSum = new int[n + 1];
        
//         // Calculate prefix sums
//         for (int i = 0; i < n; i++) {
//             prefixSum[i + 1] = prefixSum[i] + nums[i];
//         }

//         // Arrays to store the best indices for left, middle, and right subarrays
//         int[] left = new int[n];
//         int[] right = new int[n];

//         // Compute the left best indices
//         int maxSum = prefixSum[k] - prefixSum[0];
//         left[k - 1] = 0;
//         for (int i = k; i < n; i++) {
//             int currentSum = prefixSum[i + 1] - prefixSum[i + 1 - k];
//             if (currentSum > maxSum) {
//                 maxSum = currentSum;
//                 left[i] = i + 1 - k;
//             } else {
//                 left[i] = left[i - 1];
//             }
//         }

//         // Compute the right best indices
//         maxSum = prefixSum[n] - prefixSum[n - k];
//         right[n - k] = n - k;
//         for (int i = n - k - 1; i >= 0; i--) {
//             int currentSum = prefixSum[i + k] - prefixSum[i];
//             if (currentSum >= maxSum) { // Choose lexicographically smallest
//                 maxSum = currentSum;
//                 right[i] = i;
//             } else {
//                 right[i] = right[i + 1];
//             }
//         }

//         int[] result = new int[3];
//         maxSum = 0;
//         for (int i = k; i <= n - 2 * k; i++) {
//             int leftIndex = left[i - 1];
//             int rightIndex = right[i + k];
//             int currentSum = (prefixSum[leftIndex + k] - prefixSum[leftIndex]) +
//                              (prefixSum[i + k] - prefixSum[i]) +
//                              (prefixSum[rightIndex + k] - prefixSum[rightIndex]);

//             if (currentSum > maxSum) {
//                 maxSum = currentSum;
//                 result[0] = leftIndex;
//                 result[1] = i;
//                 result[2] = rightIndex;
//             }
//         }

//         return result;
//     }
// }


class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sums = new int[n - k + 1];  // Store sums of all possible k-sized subarrays
        
        // Calculate sum of first window
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        sums[0] = windowSum;
        
        // Calculate sums for remaining windows using sliding window
        for (int i = k; i < n; i++) {
            windowSum = windowSum + nums[i] - nums[i - k];
            sums[i - k + 1] = windowSum;
        }
        
        // left[i] stores the index of max sum subarray from start to i
        int[] left = new int[sums.length];
        int bestIndex = 0;
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] > sums[bestIndex]) {
                bestIndex = i;
            }
            left[i] = bestIndex;
        }
        
        // right[i] stores the index of max sum subarray from i to end
        int[] right = new int[sums.length];
        bestIndex = sums.length - 1;
        for (int i = sums.length - 1; i >= 0; i--) {
            if (sums[i] >= sums[bestIndex]) {  // >= gives lexicographically smaller result
                bestIndex = i;
            }
            right[i] = bestIndex;
        }
        
        // Find the best combination of three subarrays
        int[] result = new int[]{-1, -1, -1};
        int maxSum = 0;
        // Try all possible middle positions
        for (int i = k; i < sums.length - k; i++) {
            int leftIndex = left[i - k];
            int rightIndex = right[i + k];
            int totalSum = sums[leftIndex] + sums[i] + sums[rightIndex];
            
            if (result[0] == -1 || totalSum > maxSum || 
                (totalSum == maxSum && isLexicographicallySmaller(leftIndex, i, rightIndex, result))) {
                maxSum = totalSum;
                result[0] = leftIndex;
                result[1] = i;
                result[2] = rightIndex;
            }
        }
        
        return result;
    }
    
    private boolean isLexicographicallySmaller(int left, int mid, int right, int[] current) {
        if (left != current[0]) return left < current[0];
        if (mid != current[1]) return mid < current[1];
        return right < current[2];
    }
}