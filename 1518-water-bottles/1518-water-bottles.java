class Solution {
    public int numWaterBottles(int numBottles, int numExchange)
    {
        int ans = numBottles;
        while(numBottles >= numExchange)
        {
            int exchanged = numBottles / numExchange;
            ans += exchanged;
            numBottles = exchanged + numBottles % numExchange;
        }
        return ans;
        
    }
}