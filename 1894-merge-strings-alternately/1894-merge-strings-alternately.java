class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int minLength = Math.min(word1.length(), word2.length());
        int i = 0;
        // Append characters alternately from both strings up to the minimum length
        while (i < minLength) {
            result.append(word1.charAt(i));
            result.append(word2.charAt(i));
            i++;
        }
        // Append remaining characters from word1, if any
        if (i < word1.length()) {
            result.append(word1.substring(i));
        }
        // Append remaining characters from word2, if any
        if (i < word2.length()) {
            result.append(word2.substring(i));
        }
        return result.toString();
    }
}