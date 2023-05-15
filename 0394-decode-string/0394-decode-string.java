class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String result = "";
        int i = 0;
        
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int count = 0;
                while (Character.isDigit(s.charAt(i))) {
                    count = count * 10 + (s.charAt(i) - '0');
                    i++;
                }
                countStack.push(count);
            } else if (s.charAt(i) == '[') {
                stringStack.push(result);
                result = "";
                i++;
            } else if (s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder(stringStack.pop());
                int repeatTimes = countStack.pop();
                for (int j = 0; j < repeatTimes; j++) {
                    sb.append(result);
                }
                result = sb.toString();
                i++;
            } else {
                result += s.charAt(i);
                i++;
            }
        }
        
        return result;
    }
}