class Solution {
    public int minGroups(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int maxConcurrentIntervals = 0;
        int j = 0;
        
        for (int i = 0; i < intervals.length; i++) {
            if (starts[i] <= ends[j]) {
                maxConcurrentIntervals++;
            } else {
                j++;
            }
        }
        
        return maxConcurrentIntervals;
    }
}