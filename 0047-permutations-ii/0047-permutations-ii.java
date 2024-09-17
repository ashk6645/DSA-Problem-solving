class Solution
{
    public List<List<Integer>> permuteUnique(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), res, visited);
        return res;
    }
    private static void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result, boolean[] visited) 
    {
        if (current.size() == nums.length) 
        {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) 
        {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) 
            {
                continue;
            }
            visited[i] = true;
            current.add(nums[i]);
            backtrack(nums, current, result, visited);
            visited[i] = false;
            current.remove(current.size() - 1);
        }
}
}