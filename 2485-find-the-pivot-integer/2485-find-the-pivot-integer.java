class Solution {
    public int pivotInteger(int n) {
        // Calculate the total sum of integers from 1 to n
        long totalSum = (long)n * (n + 1) / 2;

        // Iterate through each integer from 1 to n
        long sumLeft = 0;
        for (int i = 1; i <= n; i++) {
            sumLeft += i;
            // Check if the current integer is a pivot integer
            if (sumLeft - i == totalSum - sumLeft) {
                return i;
            }
        }

        // No pivot integer found
        return -1;
    }
}
