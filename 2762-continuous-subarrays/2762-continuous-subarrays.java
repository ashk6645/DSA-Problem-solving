class Solution {
    public long continuousSubarrays(int[] nums) {
         Map<Integer, Integer> cnt = new HashMap<>();
        int i = 0;
        long res = 0;
        for (int j = 0; j < nums.length; j ++) {
            cnt.put(nums[j], cnt.getOrDefault(nums[j], 0) + 1);
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int k: cnt.keySet()) {
                max = Math.max(max, k);
                min = Math.min(min, k);
            }
            while (max - min > 2) {
                cnt.put(nums[i], cnt.get(nums[i]) - 1);
                if (cnt.get(nums[i]) == 0) {
                    cnt.remove(nums[i]);
                }
                i ++;
                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;
                for (int k: cnt.keySet()) {
                    max = Math.max(max, k);
                    min = Math.min(min, k);
                }
            }
            res += j - i + 1;
        }
        return res;
        
    }
}