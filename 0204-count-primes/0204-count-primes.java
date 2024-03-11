class Solution {
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n];
        for(int i=2;i<n;i++)
        {
            prime[i] = true;
        }
         for (int p = 2; p * p < n; p++) 
         {
            // If prime[p] is not changed, then it is a prime
            if (prime[p]) 
            {
                // Update all multiples of p
                for (int i = p * p; i < n; i += p)
                {
                    prime[i] = false;
                }
            }
        }
        int count = 0;
        for(int i=2;i<n;i++)
        {
            if(prime[i])
            {
                count++;
            }
        }
        return count;

    }
}