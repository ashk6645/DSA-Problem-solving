class Solution {
    public int countPrimes(int n) {
        if(n<=2)
        {
            return 0;
        }
        int count = 1;
        boolean[] prime = new boolean[n];
        for(int i=3;i<n;i+=2)
        {
            prime[i] = true;
        }
         for (int p = 3; p * p < n; p+=2) 
         {
            // If prime[p] is not changed, then it is a prime
            if (prime[p]) 
            {
                // Update all multiples of p
                for (int i = p * p; i < n; i += 2*p)
                {
                    prime[i] = false;
                }
            }
        }
        
        for(int i=3;i<n;i+=2)
        {
            if(prime[i])
            {
                count++;
            }
        }
        return count;

    }
}