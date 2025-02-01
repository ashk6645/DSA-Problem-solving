class Solution {
    public boolean isArraySpecial(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            // If both elements have the same parity, return false
            if ((nums[i] % 2) == (nums[i + 1] % 2)) {
                return false;
            }
        }
        // If all adjacent elements have different parity, return true
        return true;
    }
}