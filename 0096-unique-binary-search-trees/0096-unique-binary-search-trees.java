class Solution {
    public int numTrees(int n) {
        long ans = 1;
        for(int i=0; i<n; i++){
            ans *= (2*n-i);
            ans /= (i+1);
        }
        return (int)(ans / (n+1));
    }
}