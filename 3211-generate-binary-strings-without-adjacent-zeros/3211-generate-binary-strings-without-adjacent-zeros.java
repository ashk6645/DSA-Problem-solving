class Solution 
{
    public List<String> validStrings(int n)
    {
        if (n == 0) return new ArrayList<>();
        
        List<String> dp0 = new ArrayList<>(); // strings ending with '0'
        List<String> dp1 = new ArrayList<>(); // strings ending with '1'
        
        dp0.add("0");
        dp1.add("1");
        
        for (int i = 2; i <= n; i++) {
            List<String> newDp0 = new ArrayList<>();
            List<String> newDp1 = new ArrayList<>();
            
            // All strings ending with '1' can have '0' appended
            for (String s : dp1) {
                newDp0.add(s + "0");
            }
            
            // All strings can have '1' appended
            for (String s : dp0) {
                newDp1.add(s + "1");
            }
            for (String s : dp1) {
                newDp1.add(s + "1");
            }
            
            dp0 = newDp0;
            dp1 = newDp1;
        }
        
        // Merge results from both dp0 and dp1
        dp1.addAll(dp0);
        return dp1;
    }
}