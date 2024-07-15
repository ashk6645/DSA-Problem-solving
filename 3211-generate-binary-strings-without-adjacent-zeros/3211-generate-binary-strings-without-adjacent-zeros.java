class Solution 
{
    public List<String> validStrings(int n)
    {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), n, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, int n, int lastDigit) {
        if (current.length() == n) {
            result.add(current.toString());
            return;
        }

        // Append '0' if the last digit was '1' or if the string is empty
        if (lastDigit == 1 || current.length() == 0) {
            current.append('0');
            backtrack(result, current, n, 0);
            current.deleteCharAt(current.length() - 1);
        }

        // Append '1'
        current.append('1');
        backtrack(result, current, n, 1);
        current.deleteCharAt(current.length() - 1);
    }
}