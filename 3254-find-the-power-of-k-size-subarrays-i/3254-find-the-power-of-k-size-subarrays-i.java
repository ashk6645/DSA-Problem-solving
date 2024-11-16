class Solution {
    public int[] resultsArray(int[] nums, int k) {
        if (k == 1) {
            return nums; 
        }

        int length = nums.length;
        int[] result = new int[length - k + 1];
        Arrays.fill(result, -1); 
        int consecutiveCount = 1; 

        for (int index = 0; index < length - 1; index++) {
            if (nums[index] + 1 == nums[index + 1]) {
                consecutiveCount++;
            } else {
                consecutiveCount = 1; 
            }

            if (consecutiveCount >= k) {
                result[index - k + 2] = nums[index + 1];
            }
        }

        return result;
        
    }
}