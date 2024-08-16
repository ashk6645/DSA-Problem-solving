class Solution 
{
    public int maxDistance(List<List<Integer>> arrays) 
    {
        int result = 0;
        int minValue = arrays.get(0).get(0);
        int maxValue = arrays.get(0).get(arrays.get(0).size()-1);
        for(int i=1; i<arrays.size(); i++)
        {
            List<Integer> currentArray = arrays.get(i);
            int currentMin = currentArray.get(0);
            int currentMax = currentArray.get(currentArray.size() - 1);
            result = Math.max(result, Math.abs(currentMax - minValue));
            result = Math.max(result, Math.abs(maxValue - currentMin));
            minValue = Math.min(minValue, currentMin);
            maxValue = Math.max(maxValue, currentMax);
        }
        return result;
    }
}