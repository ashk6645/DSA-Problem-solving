class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];
        boolean[] seenA = new boolean[n + 1];
        boolean[] seenB = new boolean[n + 1];
        int commonCount = 0;
   
        for (int i = 0; i < n; i++) {
            // Process current number from A
            if (seenB[A[i]]) {
                commonCount++;
            }
            seenA[A[i]] = true;
            
            if (seenA[B[i]]) {
                commonCount++;
            }
            seenB[B[i]] = true;
            C[i] = commonCount;
        }
        
        return C;
    }
}