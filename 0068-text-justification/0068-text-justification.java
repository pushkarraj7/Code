class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        
        int i = 0;
        while (i < n) {
            int j = i + 1;
            int lineLength = words[i].length();
            
            while (j < n && lineLength + words[j].length() + (j - i - 1) < maxWidth) {
                lineLength += words[j].length();
                j++;
            }
            
            int extraSpaces = maxWidth - lineLength;
            int totalSpaces = j - i - 1;
            StringBuilder sb = new StringBuilder();
            if (j == n || totalSpaces == 0) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        sb.append(" ");
                    }
                }
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } else {
                int spacesPerWord = extraSpaces / totalSpaces;
                int extraSpacesRemaining = extraSpaces % totalSpaces;
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        for (int space = 0; space < spacesPerWord; space++) {
                            sb.append(" ");
                        }
                        if (extraSpacesRemaining > 0) {
                            sb.append(" ");
                            extraSpacesRemaining--;
                        }
                    }
                }
            }
            result.add(sb.toString());
            i = j;
        }        
        return result;
    }
}