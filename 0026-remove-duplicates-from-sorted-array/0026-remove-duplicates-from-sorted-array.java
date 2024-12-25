class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int uniqueIdx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIdx]) {
                uniqueIdx++; 
                nums[uniqueIdx] = nums[i]; 
        }
      
        
    }
          return uniqueIdx + 1;
}
}