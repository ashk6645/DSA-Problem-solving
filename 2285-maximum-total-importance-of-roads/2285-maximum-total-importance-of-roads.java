class Solution 
{
    public long maximumImportance(int n, int[][] roads)
    {
        long[] cityImportance = new long[n];

        for (int[] edge : roads) {
            cityImportance[edge[0]]++;
            cityImportance[edge[1]]++;
        }

        Arrays.sort(cityImportance);

        long value = 1;
        long totalImportance = 0;
        for (long d : cityImportance) {
            totalImportance += (value * d);
            value++;
        }

        return totalImportance;
        
    }
}