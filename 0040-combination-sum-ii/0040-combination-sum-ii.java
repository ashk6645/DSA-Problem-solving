class Solution
{
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
         List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); 
        findCombinations(candidates, 0, target, new ArrayDeque<>(), result);
        return result;
    }
    
    private void findCombinations(int[] candidates, int index, int target, Deque<Integer> current, List<List<Integer>> result) {
        if (target == 0) 
        {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1])
            {
                continue;
            }
            
            int candidate = candidates[i];
            if (candidate > target)
            {
                break;
            }
            
            current.addLast(candidate);
            findCombinations(candidates, i + 1, target - candidate, current, result);
            current.removeLast(); // Backtrack by removing the last element
        } 
            
        
    }
}