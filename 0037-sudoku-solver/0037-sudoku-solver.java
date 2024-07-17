import java.util.ArrayList;
import java.util.List;

class Solution {

    private static final int SIZE = 9;
    private static final int SUBGRID_SIZE = 3;

    // Define bitmasks to track used numbers
    private int[] rows = new int[SIZE];
    private int[] cols = new int[SIZE];
    private int[] boxes = new int[SIZE];
    private List<int[]> emptyCells = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        // Initialize the bitmasks and list of empty cells
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == '.') {
                    emptyCells.add(new int[]{i, j});
                } else {
                    int num = board[i][j] - '1';
                    rows[i] |= 1 << num;
                    cols[j] |= 1 << num;
                    boxes[3 * (i / SUBGRID_SIZE) + j / SUBGRID_SIZE] |= 1 << num;
                }
            }
        }
        // Start solving from the first empty cell
        solve(board, 0);
    }

    private boolean solve(char[][] board, int index) {
        // Base case: If all empty cells are filled, the solution is found
        if (index == emptyCells.size()) {
            return true;
        }

        int[] cell = emptyCells.get(index);
        int row = cell[0];
        int col = cell[1];
        int boxIndex = 3 * (row / SUBGRID_SIZE) + col / SUBGRID_SIZE;

        // Try different numbers in the current cell
        for (int num = 0; num < SIZE; num++) {
            if ((rows[row] & (1 << num)) == 0 &&
                (cols[col] & (1 << num)) == 0 &&
                (boxes[boxIndex] & (1 << num)) == 0) {

                // Place the number and update the bitmasks
                board[row][col] = (char) (num + '1');
                rows[row] |= 1 << num;
                cols[col] |= 1 << num;
                boxes[boxIndex] |= 1 << num;

                // Move to the next empty cell
                if (solve(board, index + 1)) {
                    return true;
                }

                // Backtrack to the previous state
                board[row][col] = '.';
                rows[row] &= ~(1 << num);
                cols[col] &= ~(1 << num);
                boxes[boxIndex] &= ~(1 << num);
            }
        }

        // No valid solution found
        return false;
    }
}
