class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        String doubleString = s+s;
        return kmpSearch(doubleString, goal);
    }
    private boolean kmpSearch(String text, String pattern){
        int[] lps = computeLPS(pattern);
        int textIndex = 0, patternIndex = 0;
        int textLength = text.length(), patternLength = pattern.length();
        while (textIndex < textLength) {
                        if (text.charAt(textIndex) == pattern.charAt(patternIndex)) {
                textIndex++;
                patternIndex++;
                if (patternIndex == patternLength) return true;
            }
            else if (patternIndex > 0) {
                patternIndex = lps[patternIndex - 1];
            }
            else {
                textIndex++;
            }
        }
        return false;
    }

    private int[] computeLPS(String pattern) {
        int patternLength = pattern.length();
        int[] lps = new int[patternLength];
        int length = 0, index = 1;
        while (index < patternLength) {
            if (pattern.charAt(index) == pattern.charAt(length)) {
                length++;
                lps[index++] = length;
            }
            else if (length > 0) {
                length = lps[length - 1];
            }
            else {
                lps[index++] = 0;
            }
        }
        return lps;
    }
}