class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int contentChildren = 0;
        int i = 0; // Index for children
        int j = 0; // Index for cookies

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                contentChildren++;
                i++;
            }
            j++;
        }

        return contentChildren;
    }
}