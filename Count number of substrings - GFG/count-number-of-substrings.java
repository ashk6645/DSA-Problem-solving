//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public long substrCount(String s, int k) {
        return atMostKDistinct(s, k) - atMostKDistinct(s, k - 1);
    }

    private long atMostKDistinct(String s, int k) {
        int[] charCount = new int[26];
        int distinct = 0, left = 0;
        long result = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            charCount[rightChar - 'a']++;

            if (charCount[rightChar - 'a'] == 1) {
                distinct++;
            }

            while (distinct > k) {
                char leftChar = s.charAt(left);
                charCount[leftChar - 'a']--;

                if (charCount[leftChar - 'a'] == 0) {
                    distinct--;
                }

                left++;
            }

            result += (right - left + 1);
        }

        return result;
    }
}
