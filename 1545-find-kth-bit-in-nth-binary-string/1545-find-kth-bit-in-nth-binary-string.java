class Solution {
    public char findKthBit(int n, int k) {
        int posInSec = k & -k;
        boolean isInInvert = (((k/posInSec)>>1)&1)==1;
        boolean originalBitIsOne = (k & 1) == 0;
        if(isInInvert)
        {
            return originalBitIsOne ? '0' : '1';
        }
        else
        {
            return originalBitIsOne ? '1' : '0';
        }
        
    }
}