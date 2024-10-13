class Solution 
{
    public int[] smallestRange(List<List<Integer>> nums) 
    {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) 
        {
            int num = nums.get(i).get(0);
            pq.add(new int[]{num, i, 0});
            max = Math.max(max, num); 
        }

        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;
        while (pq.size() == nums.size()) 
        {
            int[] current = pq.poll();
            int value = current[0], listIndex = current[1], elementIndex = current[2];

        
            if (max - value < rangeEnd - rangeStart) 
            {
                rangeStart = value;
                rangeEnd = max;
            }

            if (elementIndex + 1 < nums.get(listIndex).size()) 
            {
                int nextValue = nums.get(listIndex).get(elementIndex + 1);
                pq.add(new int[]{nextValue, listIndex, elementIndex + 1});
                max = Math.max(max, nextValue); 
            }
        }

        return new int[]{rangeStart, rangeEnd}; 
    }
}