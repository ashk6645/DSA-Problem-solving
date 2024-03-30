class Solution 
{
    public String reverseVowels(String s)
    {
         if (s == null || s.length() <= 1) {
            return s;
        }
        
        // Convert string to char array for easier manipulation
        char[] chars = s.toCharArray();
        
        // Define vowels set
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        
        // Two pointers approach to reverse vowels
        int left = 0, right = chars.length - 1;
        while (left < right) {
            // Move left pointer to next vowel
            while (left < right && !vowels.contains(chars[left])) {
                left++;
            }
            // Move right pointer to previous vowel
            while (left < right && !vowels.contains(chars[right])) {
                right--;
            }
            // Swap vowels
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        
        // Convert char array back to string
        return new String(chars);
        
    }
}