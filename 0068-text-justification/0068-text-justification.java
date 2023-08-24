class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int width = words[i].length();
            int j = i + 1;
            while (j < words.length && width + words[j].length() + (j - i) <= maxWidth) {
                width += words[j].length();
                j++;
            }

            int spaces = maxWidth - width;
            int gaps = j - i - 1;

            StringBuilder line = new StringBuilder(words[i]);
            
            if (gaps == 0 || j == words.length) { // Left justify or last line
                for (int k = i + 1; k < j; k++) {
                    line.append(" ").append(words[k]);
                }
                line.append(" ".repeat(maxWidth - line.length()));
            } else {
                int spacesPerGap = spaces / gaps;
                int extraSpaces = spaces % gaps;
                for (int k = i + 1; k < j; k++) {
                    int spacesToAdd = spacesPerGap + (extraSpaces-- > 0 ? 1 : 0);
                    line.append(" ".repeat(spacesToAdd)).append(words[k]);
                }
            }

            res.add(line.toString());
            i = j;
        }

        return res;
    }
}
