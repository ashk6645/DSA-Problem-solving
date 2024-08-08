class Solution
{
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) 
    {
      int[][] result = new int[rows * cols][];
       int currentRow = rStart, currentCol = cStart, deltaRow = 0, deltaCol = 1, steps = 0, count = 0;
        while (count < rows * cols)
        {
            for (int i = 0; i < steps / 2 + 1; i++)
            {
            if (currentRow >= 0 && currentRow < rows && currentCol >= 0 && currentCol < cols)
                    result[count++] = new int[] { currentRow, currentCol };
                currentRow += deltaRow;
                currentCol += deltaCol;
            }
            if (deltaCol == 1) 
            { 
                deltaCol = 0;
                deltaRow = 1;
            }
            else if (deltaRow == 1)
            { 
                deltaRow = 0;
                deltaCol = -1;
            }
            else if (deltaCol == -1) 
            { 
                deltaCol = 0;
                deltaRow = -1;
            }
            else if (deltaRow == -1)
            { 
                deltaRow = 0;
                deltaCol = 1;
            }
            steps++;
        }
        return result;
              
    }
}