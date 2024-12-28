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
        int[] sum = new int[n + 1]; // cumulative sum array
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[3];

        // Find the starting index of the maximum sum subarray for the left interval
        int maxSum = sum[k] - sum[0];
        for (int i = k; i < n; i++) {
            if (sum[i + 1] - sum[i + 1 - k] > maxSum) {
                maxSum = sum[i + 1] - sum[i + 1 - k];
                left[i] = i + 1 - k;
            } else {
                left[i] = left[i - 1];
            }
        }

        // Find the starting index of the maximum sum subarray for the right interval
        maxSum = sum[n] - sum[n - k];
        right[n - k] = n - k;
        for (int i = n - k - 1; i >= 0; i--) {
            if (sum[i + k] - sum[i] >= maxSum) {
                maxSum = sum[i + k] - sum[i];
                right[i] = i;
            } else {
                right[i] = right[i + 1];
            }
        }

        // Find the maximum sum of three non-overlapping subarrays
        maxSum = 0;
        for (int i = k; i <= n - 2 * k; i++) {
            int l = left[i - 1];
            int r = right[i + k];
            int total = (sum[i + k] - sum[i]) + (sum[l + k] - sum[l]) + (sum[r + k] - sum[r]);
            if (total > maxSum) {
                maxSum = total;
                result[0] = l;
                result[1] = i;
                result[2] = r;
            }
        }

        return result;
    }

   
}
