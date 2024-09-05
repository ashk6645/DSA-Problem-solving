class Solution 
{
    public List<Integer> getRow(int rowIndex)
    {
        List<Integer> row = new ArrayList<>();
        long currentElement = 1;
        row.add((int) currentElement);
        for(int i = 1; i<=rowIndex; i++)
        {
            currentElement = currentElement * (rowIndex - i + 1)/i;
            row.add((int)currentElement);
        }
        return row;
    }
}