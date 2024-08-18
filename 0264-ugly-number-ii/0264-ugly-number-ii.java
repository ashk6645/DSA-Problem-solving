class Solution
{
    public int nthUglyNumber(int n)
    {
        int[] u = new int[n];
        u[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; ++i)
        {
            u[i] = Math.min(u[i2] * 2, Math.min(u[i3] * 3, u[i5] * 5));
            if (u[i] == u[i2] * 2) i2++;
            if (u[i] == u[i3] * 3) i3++;
            if (u[i] == u[i5] * 5) i5++;
        }
        return u[n - 1];
        
    }
}