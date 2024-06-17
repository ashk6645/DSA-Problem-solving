import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        int operations = 0;

        for (int num : nums) {
            int complement = k - num;
            int complementCount = counts.getOrDefault(complement, 0);
            
            if (complementCount > 0) {
                operations++;
                counts.put(complement, complementCount - 1);
            } else {
                counts.put(num, counts.getOrDefault(num, 0) + 1);
            }
        }

        return operations;
    }
}
