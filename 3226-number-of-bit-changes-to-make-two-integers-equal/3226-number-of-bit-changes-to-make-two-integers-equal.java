class Solution 
{
    public int minChanges(int n, int k)
    {
        int count = 0;
        while (n > 0 && k > 0) {
            int nthBit = n & 1;
            int kthBit = k & 1;
            if(nthBit == 0 && kthBit == 1)
                return -1;
            else if(nthBit == 1 && kthBit == 0)
                count++;
            n = n >> 1;
            k = k >> 1;
        }

        while (n > 0)
        {
            int nthBit = n & 1;
            int kthBit = k & 1;
            if(nthBit == 0 && kthBit == 1)
                return -1;
            else if(nthBit == 1 && kthBit == 0)
                count++;
            n = n >> 1;
            k = k >> 1;
        }

        
        while (k > 0) 
        {
            int nthBit = n & 1;
            int kthBit = k & 1;
            if(nthBit == 0 && kthBit == 1)
                return -1;
            else if(nthBit == 1 && kthBit == 0)
                count++;
            n = n >> 1;
            k = k >> 1;
        }

        return count;
}
}