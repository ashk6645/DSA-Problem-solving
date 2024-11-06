class Solution {
    public boolean canSortArray(int[] nums) {
         int n = nums.length;

        int[] values = Arrays.copyOf(nums, n);

        for (int i = 0; i < n - 1; i++) {
            if (values[i] <= values[i + 1]) {
                continue;
            } else {
                
                if (
                    Integer.bitCount(values[i]) ==
                    Integer.bitCount(values[i + 1])
                ) {
                   
                    int temp = values[i];
                    values[i] = values[i + 1];
                    values[i + 1] = temp;
                } else {
                    return false; 
                }
            }
        }
        for (int i = n - 1; i >= 1; i--) {
            if (values[i] >= values[i - 1]) {
                continue;
            } else {
               
                if (
                    Integer.bitCount(values[i]) ==
                    Integer.bitCount(values[i - 1])
                ) {
             
                    int temp = values[i];
                    values[i] = values[i - 1];
                    values[i - 1] = temp;
                } else {
                    return false;
                }
            }
        }

        return true;
        
    }
}