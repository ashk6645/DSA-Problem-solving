class Solution 
{
    public int[] frequencySort(int[] nums)
    {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        
        Integer[] numsArray = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numsArray, (a, b) -> {int freqCompare = frequencyMap.get(a).compareTo(frequencyMap.get(b));
            if (freqCompare == 0) {
                return b.compareTo(a); 
            }
            return freqCompare;
        });

       
        return Arrays.stream(numsArray).mapToInt(Integer::intValue).toArray();
    }

        
    }
