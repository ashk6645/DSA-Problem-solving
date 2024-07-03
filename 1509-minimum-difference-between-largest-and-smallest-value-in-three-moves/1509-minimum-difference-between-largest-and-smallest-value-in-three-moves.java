class Solution 
{
    public int minDifference(int[] nums) 
    {
        Arrays.sort(nums);
        if(nums.length<=4)
        {
            return 0;
        }
        int n = nums.length;
        
       //We have four options after sorting
        int opt1 = nums[n-4] - nums[0];      //1. Change three largets element.
        
        int opt2 = nums[n-3] - nums[1];      //2.Change two largest and the smallest element.
       
        int opt3 = nums[n-2] - nums[2];      //3.Change the largest and two smallest element.   
        
        int opt4 = nums[n-1] - nums[3];      //4.Cganhe the three smallest element.
       
        return Math.min(Math.min(opt1, opt2), Math.min(opt3, opt4));
        
    }
}