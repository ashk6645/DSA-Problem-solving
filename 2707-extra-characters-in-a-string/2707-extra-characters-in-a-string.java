class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> dictSet = new HashSet<>();
        for (String word : dictionary) {
            dictSet.add(word);
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1; // Assume the current character is extra
            for (String word : dictSet) {
                int len = word.length();
                if (i >= len && s.substring(i - len, i).equals(word)) {
                    dp[i] = Math.min(dp[i], dp[i - len]);
                }
            }
        }
        
        return dp[n];
    }
}