class Solution
{
    public boolean wordPattern(String pattern, String s) 
    {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) 
        {
            return false;
        }

        HashMap<Character, String> patternToWord = new HashMap<>();
        HashMap<String, Character> wordToPattern = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++)
        {
            char key = pattern.charAt(i);
            String value = words[i];

            if (patternToWord.containsKey(key))
            {
                if (!patternToWord.get(key).equals(value)) 
                {
                    return false;
                }
            }
            else
            {
                if (wordToPattern.containsKey(value))
                {
                    return false;
                }
                patternToWord.put(key, value);
                wordToPattern.put(value, key);
            }
        }

        return true;
        
    }
}