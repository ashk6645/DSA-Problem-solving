class Solution 
{
    public int passThePillow(int n, int time) 
    {
        int completePass = time / (2*(n-1));
        int remainingSeconds = time % (2 * (n-1));
        boolean isForward = remainingSeconds < n;
        int currentPosition = isForward ? remainingSeconds : 2 * (n-1)-remainingSeconds;
        return currentPosition + 1;
        
    }
}