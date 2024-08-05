class Solution 
{
    public String kthDistinct(String[] arr, int k)
    {
       Map<String, Integer> countMap = new LinkedHashMap<>();
        for (String s : arr)
        {
            countMap.put(s, countMap.getOrDefault(s, 0) + 1);
        }
        int distinctCount = 0;
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) 
        {
            if (entry.getValue() == 1)
            {
                distinctCount++;
                if (distinctCount == k) 
                {
                    return entry.getKey();
                }
            }
        }
        return ""; 
    }
}