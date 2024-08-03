class Solution 
{
    public boolean canBeEqual(int[] target, int[] arr) 
    {
        if(target.length != arr.length)
        {
            return false;
        }
        
        int[] count = new int[1001];
        for(int i=0;i<target.length;i++)
        {
            count[target[i]]++;
            count[arr[i]]--; 
        }
        for(int i = 0; i<count.length;i++)
        {
            if(count[i] != 0)
            {
                return false;
            }
        }
        return true;
        
    }
}