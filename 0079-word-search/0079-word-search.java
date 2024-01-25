class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, wordArray, 0)) {
                    return true;
                }
            }
        }

        return false;
    
        
    }
     private boolean dfs(char[][] board, int i, int j, char[] word, int index) {
        if (index == word.length) {
            return true; // Found the complete word
        }

        int m = board.length;
        int n = board[0].length;

       
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word[index]) {
            return false;
        }

        // Mark the current cell as visited
        char temp = board[i][j];
        board[i][j] = '*';

        // Explore adjacent cells
        boolean result = dfs(board, i + 1, j, word, index + 1) ||
                         dfs(board, i - 1, j, word, index + 1) ||
                         dfs(board, i, j + 1, word, index + 1) ||
                         dfs(board, i, j - 1, word, index + 1);

        // Restore the original value of the current cell
        board[i][j] = temp;

        return result;
     }
}