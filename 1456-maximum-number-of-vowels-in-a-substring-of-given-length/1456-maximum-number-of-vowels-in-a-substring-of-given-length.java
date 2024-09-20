class Solution 
{
    public int maxVowels(String s, int k) 
    {
        int maxVowels = 0;
        int vowelCount = 0;
    
    // Count the number of vowels in the first k characters
    for (int i = 0; i < k; i++) 
    {
        if (isVowel(s.charAt(i))) 
        {
            vowelCount++;
        }
    }
    
    maxVowels = Math.max(maxVowels, vowelCount);
    
    // Slide the window and update the vowel count
    for (int i = k; i < s.length(); i++)
    {
        if (isVowel(s.charAt(i)))
        {
            vowelCount++;
        }
        if (isVowel(s.charAt(i - k)))
        {
            vowelCount--;
        }
        maxVowels = Math.max(maxVowels, vowelCount);
    }
    
    return maxVowels;
}

private boolean isVowel(char c) 
{
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
}
        
    
}