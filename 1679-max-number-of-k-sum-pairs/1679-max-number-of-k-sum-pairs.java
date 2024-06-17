class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        int operations = 0;

        for (int num : nums) {
            int complementCount = counts.getOrDefault(k - num, 0);
            if (complementCount > 0) {
                operations++;
                counts.put(k - num, complementCount - 1);
            } else {
                counts.put(num, counts.getOrDefault(num, 0) + 1);
            }
        }

        return operations;
    }
}
