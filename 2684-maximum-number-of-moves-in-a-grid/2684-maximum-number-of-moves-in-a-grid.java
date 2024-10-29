class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[] current = new boolean[m];
        Arrays.fill(current, true);  
        int moves = 0;
        
        for (int j = 1; j < n && moves + 1 < n; j++) {
            boolean[] next = new boolean[m];
            boolean anyValid = false; 
            
            for (int i = 0; i < m; i++) {
                if (!current[i]) continue;  
                for (int k = Math.max(0, i - 1); k <= Math.min(m - 1, i + 1); k++) {
                    if (grid[k][j] > grid[i][j - 1]) {
                        next[k] = true;
                        anyValid = true;
                    }
                }
            }
            
            if (!anyValid) break;
            
            moves++;
            current = next;
        }
        
        return moves;
    }
}