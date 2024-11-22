class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
                Map<String, Integer> patternFrequency = new HashMap<>();

        for (int[] currentRow : matrix) {
            StringBuilder patternBuilder = new StringBuilder("");

            for (int col = 0; col < currentRow.length; col++) {
                if (currentRow[0] == currentRow[col]) {
                    patternBuilder.append("T");
                } else {
                    patternBuilder.append("F");
                }
            }

            String rowPattern = patternBuilder.toString();
            patternFrequency.put(
                rowPattern,
                patternFrequency.getOrDefault(rowPattern, 0) + 1
            );
        }
        int maxFrequency = 0;
        for (int frequency : patternFrequency.values()) {
            maxFrequency = Math.max(frequency, maxFrequency);
        }

        return maxFrequency;
    }
}