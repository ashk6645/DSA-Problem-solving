class Solution
{
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int maxWidth = 0;
        
        // Monotonic stack to keep track of smallest indices
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }
        
        
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                maxWidth = Math.max(maxWidth, i - stack.pop());
            }
        }
        
        return maxWidth;
    }
}