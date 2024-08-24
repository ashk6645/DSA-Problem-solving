class Solution 
{
    public String nearestPalindromic(String n)
    {
       int length = n.length();
        Set<String> candidates = new HashSet<>();

               if (n.equals("1")) return "0";

       
        String prefix = n.substring(0, (length + 1) / 2);
        long prefixNumber = Long.parseLong(prefix);

        for (long i : new long[] {-1, 0, 1}) {
            String newPrefix = Long.toString(prefixNumber + i);
            String candidate;
            if (length % 2 == 0) {
                candidate = newPrefix + new StringBuilder(newPrefix).reverse().toString();
            } else {
                candidate = newPrefix + new StringBuilder(newPrefix.substring(0, newPrefix.length() - 1)).reverse().toString();
            }
            candidates.add(candidate);
        }

               candidates.add(Long.toString((long)Math.pow(10, length - 1) - 1));
        candidates.add(Long.toString((long)Math.pow(10, length) + 1));

        candidates.remove(n);
        String closestPalindrome = "";
        long minDifference = Long.MAX_VALUE;
        long num = Long.parseLong(n);
        for (String candidate : candidates)
        {
            long candidateNum = Long.parseLong(candidate);
            long difference = Math.abs(candidateNum - num);
            if (difference < minDifference || (difference == minDifference && candidateNum < Long.parseLong(closestPalindrome))) 
            {
                minDifference = difference;
                closestPalindrome = candidate;
            }
        }

        return closestPalindrome;
    }
}