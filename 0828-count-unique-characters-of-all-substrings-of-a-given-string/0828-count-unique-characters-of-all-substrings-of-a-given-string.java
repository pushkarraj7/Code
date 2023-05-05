class Solution {
    public int uniqueLetterString(String s) {
        int[] lastPos = new int[26];
        int[] contribution = new int[26];
        int sum = 0, res = 0;
        Arrays.fill(lastPos, -1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sum -= contribution[c - 'A'];
            contribution[c - 'A'] = i - lastPos[c - 'A'];
            sum += contribution[c - 'A'];
            lastPos[c - 'A'] = i;
            res += sum;
        }
        return res;
    }
}