class Solution 
{
    public int removeDuplicates(int[] nums)
    {
         int idxIntoNums = 0;  

        for (int n : nums)  
        { 
            if (idxIntoNums < 2)
            {
                nums[idxIntoNums++] = n;
                continue;
            }

            if (n != nums[idxIntoNums - 2])
            {
                nums[idxIntoNums++] = n;
                continue;
           }    
        }
        
        return idxIntoNums;    
    }
}