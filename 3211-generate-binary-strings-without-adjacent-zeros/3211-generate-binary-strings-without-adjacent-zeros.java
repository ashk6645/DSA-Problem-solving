class Solution 
{
    public List<String> validStrings(int n)
    {
        List<String> result = new ArrayList<>();
        if (n == 0) return result;
        backtrack(result, new StringBuilder(), n);
        return result;
    }
    
    private static void backtrack(List<String> result, StringBuilder current, int n) {
        if (current.length() == n) {
            result.add(current.toString());
            return;
        }
        
        if (current.length() == 0 || current.charAt(current.length() - 1) == '1') {
            current.append('0');
            backtrack(result, current, n);
            current.deleteCharAt(current.length() - 1);
        }
        
        current.append('1');
        backtrack(result, current, n);
        current.deleteCharAt(current.length() - 1);
    }
}