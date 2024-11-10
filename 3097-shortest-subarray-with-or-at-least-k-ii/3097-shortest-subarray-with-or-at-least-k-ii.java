class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int minLength = Integer.MAX_VALUE;
        int windowStart = 0;
        int windowEnd = 0;
        int[] bitCounts = new int[32]; // Tracks count of set bits at each position

       
        while (windowEnd < nums.length) 
        {
            updateBitCounts(bitCounts, nums[windowEnd], 1);
            while (windowStart <= windowEnd && convertBitCountsToNumber(bitCounts) >= k) 
            {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                updateBitCounts(bitCounts, nums[windowStart], -1);
                windowStart++;
            }

            windowEnd++;
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    private void updateBitCounts(int[] bitCounts, int number, int delta) 
    {
        for (int bitPosition = 0; bitPosition < 32; bitPosition++) 
        {
            if (((number >> bitPosition) & 1) != 0) 
            {
                bitCounts[bitPosition] += delta;
            }
        }
    }

    private int convertBitCountsToNumber(int[] bitCounts) 
    {
        int result = 0;
        for (int bitPosition = 0; bitPosition < 32; bitPosition++) 
        {
            if (bitCounts[bitPosition] != 0) 
            {
                result |= 1 << bitPosition;
            }
        }
        return result;
        
    }
}