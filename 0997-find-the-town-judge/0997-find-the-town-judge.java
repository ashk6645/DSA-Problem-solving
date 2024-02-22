class Solution {
    public int findJudge(int n, int[][] trust) {
int[] trustScores = new int[n+1];
int[] trustedByCount = new int[n + 1];
 for (int[] pair : trust)
 {
            int a = pair[0];
            int b = pair[1];
            trustScores[b]++;
            trustedByCount[a]++;
       
        
    }
 for (int i = 1; i <= n; i++) {
            if (trustScores[i] == n - 1 && trustedByCount[i] == 0) {
                return i; // town judge found
            }
        }

        return -1; // town judge not found
}
}