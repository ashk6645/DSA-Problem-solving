class Solution
{
    public List<List<Integer>> threeSum(int[] nums)
    {
         List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums); // Sort the array to handle duplicates

    for (int i = 0; i < nums.length - 2; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue; // Skip duplicate values for i
        }
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if (sum == 0) {
                result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                left = skipDuplicates(nums, left, right, true);
                right = skipDuplicates(nums, left, right, false);
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
    }
    return result;
}

private int skipDuplicates(int[] nums, int left, int right, boolean isLeft) {
    if (isLeft) {
        while (left < right && nums[left] == nums[left + 1]) {
            left++;
        }
        return left + 1;
    } else {
        while (left < right && nums[right] == nums[right - 1]) {
            right--;
        }
        return right - 1;
    }
}
        
    
}