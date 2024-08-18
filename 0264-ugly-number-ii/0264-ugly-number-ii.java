class Solution
{
    public int nthUglyNumber(int n)
    {
        if (n == 1) return 1;

        int i2 = 0, i3 = 0, i5 = 0;
        int nextMultipleOf2 = 2, nextMultipleOf3 = 3, nextMultipleOf5 = 5;
        int uglyNumber = 1;

        int[] u = new int[n];
        u[0] = 1;

        for (int i = 1; i < n; i++)
        {
            uglyNumber = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));
            u[i] = uglyNumber;

            if (uglyNumber == nextMultipleOf2)
            {
                i2++;
                nextMultipleOf2 = u[i2] * 2;
            }
            if (uglyNumber == nextMultipleOf3)
            {
                i3++;
                nextMultipleOf3 = u[i3] * 3;
            }
            if (uglyNumber == nextMultipleOf5)
            {
                i5++;
                nextMultipleOf5 = u[i5] * 5;
            }
        }

        return uglyNumber;
        
    }
}