class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1])); 
        
        int n = pairs.length;
        int[] dp = new int[n]; 
        
        Arrays.fill(dp, 1); 
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); 
                }
            }
        }
        
        int maxLength = 0;
        for (int length : dp) {
            maxLength = Math.max(maxLength, length);
        }
        
        return maxLength;
    
        
    }
}