class Solution 
{

    // Define arrays to track used numbers
    private boolean[][] rows = new boolean[9][9];
    private boolean[][] cols = new boolean[9][9];
    private boolean[][] boxes = new boolean[9][9];

    public void solveSudoku(char[][] board) 
    {
        // Initialize the tracking arrays based on the initial board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[3 * (i / 3) + j / 3][num] = true;
                }
            }
        }
        // Start solving from the first cell
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int row, int col)
    {
        // Base case: If row is equal to board length, entire board has been filled
        if (row == 9) 
        {
            return true;
        }

        // Move to next row when current row is fully filled
        if (col == 9)
        {
            return solve(board, row + 1, 0);
        }

        // Skip cells that are already filled
        if (board[row][col] != '.')
        {
            return solve(board, row, col + 1);
        }

        // Try different numbers in current cell
        for (int num = 0; num < 9; num++)
        {
            if (isValidPlacement(row, col, num)) 
            {
                board[row][col] = (char) (num + '1'); // Fill current cell with valid number
                rows[row][num] = true;
                cols[col][num] = true;
                boxes[3 * (row / 3) + col / 3][num] = true;

                // Move to next cell
                if (solve(board, row, col + 1)) 
                {
                    return true;
                }

                // Backtrack to previous state if solution not found
                board[row][col] = '.';
                rows[row][num] = false;
                cols[col][num] = false;
                boxes[3 * (row / 3) + col / 3][num] = false;
            }
        }

        // No valid solution found
        return false;
    }

    private boolean isValidPlacement(int row, int col, int num)
    {
        // Check if num is already used in the same row, column, or 3x3 subgrid
        return !rows[row][num] && !cols[col][num] && !boxes[3 * (row / 3) + col / 3][num];
    }
}
