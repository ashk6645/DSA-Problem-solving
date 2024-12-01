class Solution {
    public boolean checkIfExist(int[] arr) {
         Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : arr) {
            if (num != 0 && map.containsKey(2 * num)) {
                return true;
            }
            if (num == 0 && map.get(num) > 1) {
                return true;
            }
        }
        return false;
        
    }
}