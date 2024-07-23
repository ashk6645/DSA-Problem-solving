class Solution 
{
    public int[] frequencySort(int[] nums)
    {
       Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a list of the numbers
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }

        // Step 3: Sort the list with a custom comparator
        Collections.sort(numList, (a, b) -> {
            int freqCompare = frequencyMap.get(a).compareTo(frequencyMap.get(b));
            if (freqCompare == 0) {
                return b.compareTo(a); // If frequencies are the same, sort by value in decreasing order
            }
            return freqCompare; // Otherwise, sort by frequency in increasing order
        });

        // Step 4: Convert the sorted list back to an array
        int[] sortedArray = new int[nums.length];
        for (int i = 0; i < numList.size(); i++) {
            sortedArray[i] = numList.get(i);
        }

        return sortedArray;
    }
}
