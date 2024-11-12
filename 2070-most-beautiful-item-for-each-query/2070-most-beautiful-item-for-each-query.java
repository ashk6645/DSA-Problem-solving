class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        // Pre-process to remove items with lower price but lower or equal beauty
        TreeMap<Integer, Integer> priceToMaxBeauty = new TreeMap<>();
        for (int[] item : items) {
            priceToMaxBeauty.put(item[0], Math.max(
                priceToMaxBeauty.getOrDefault(item[0], 0), 
                item[1]
            ));
        }
        
        // Build running maximum beauty for each price point
        int maxSoFar = 0;
        for (Map.Entry<Integer, Integer> entry : priceToMaxBeauty.entrySet()) {
            maxSoFar = Math.max(maxSoFar, entry.getValue());
            priceToMaxBeauty.put(entry.getKey(), maxSoFar);
        }
        
        // Process queries
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            Map.Entry<Integer, Integer> entry = priceToMaxBeauty.floorEntry(queries[i]);
            result[i] = entry == null ? 0 : entry.getValue();
        }
        
        return result;
    }
}