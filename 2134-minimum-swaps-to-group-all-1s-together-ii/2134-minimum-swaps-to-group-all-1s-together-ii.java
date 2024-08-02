class Solution 
{
    public int minSwaps(int[] nums)
    {
        int count = 0;
        for(int i : nums) 
        {
            if(i == 1)
            {
                count++;
            }
        }

        if (count == 0 || count == nums.length) 
        {
            return 0;
        }

        int min = -1;
        int current = 0;
        int n = nums.length;

        for(int i = 0; i < count; i++) 
        {
            if(nums[i] == 0) 
            {
                current++;
            }
        }

        min = current;

        for(int i = count; i < n + count; i++) 
        {

            if(nums[(i-count) % n] == 0) 
            {
                current--;
            }

            if(nums[i % n] == 0) 
            {
                current++;
            }

            min = Math.min(min,current);
        }

        return min;
        
    }
}