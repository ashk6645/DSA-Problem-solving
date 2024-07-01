class Solution {
    public boolean isPowerOfFour(int n) {
        if (n == 0) {
            return false;
        }
        int pow = (int) (Math.log(n) / Math.log(4));
        return n == Math.pow(4, pow);
    }
}
