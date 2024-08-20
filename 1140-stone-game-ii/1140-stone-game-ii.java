class Solution 
{
    public int stoneGameII(int[] piles)
    {
        int n = piles.length;
        int[] totalStonesCache = new int[n + 1];
        int totalStones = 0;
        for (int index = n - 1; index >= 0; index--) {
            totalStones += piles[index];
            totalStonesCache[index] = totalStones;
        }

        // If the index is n, the answer is 0.
        int maxM = (n + 2) / 2;
        Integer[][] memo = new Integer[n + 1][maxM + 1];
        for (int m = 1; m <= maxM; m++) {
            memo[n][m] = 0;
        }

        // Solve.
        return stoneGame(n, 0, 1, totalStonesCache, memo);
    }

    private static int stoneGame(int n, int index, int m, int[] totalStonesCache, Integer[][] memo) {
        Integer maybeResult = memo[index][m];
        if (maybeResult != null) {
            return maybeResult;
        }

        int result = stoneGameUncached(n, index, m, totalStonesCache, memo);
        memo[index][m] = result;
        return result;
    }

    private static int stoneGameUncached(int n, int index, int m, int[] totalStonesCache, Integer[][] memo) {
        // Take all the stones if possible.
        int totalStones = totalStonesCache[index];
        if (index + 2 * m >= n) {
            return totalStones;
        }

        // Take up to m piles. The next value of m stays the same.
        int lastIndex = index + m;
        index++;
        int maxStones = totalStones - stoneGame(n, index, m, totalStonesCache, memo);
        for (index++; index <= lastIndex; index++) {
            int numStones = totalStones - stoneGame(n, index, m, totalStonesCache, memo);
            maxStones = Math.max(maxStones, numStones);
        }

       
        lastIndex += m;
        for (; index <= lastIndex; index++) {
            m++;
            int numStones = totalStones - stoneGame(n, index, m, totalStonesCache, memo);
            maxStones = Math.max(maxStones, numStones);
        }
        return maxStones;
    }
}