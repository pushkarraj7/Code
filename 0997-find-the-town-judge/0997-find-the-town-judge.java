class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] inDegrees = new int[N+1];
        int[] outDegrees = new int[N+1];
        for (int[] t : trust) {
            int a = t[0];
            int b = t[1];
            outDegrees[a]++;
            inDegrees[b]++;
        }
        for (int i = 1; i <= N; i++) {
            if (inDegrees[i] == N-1 && outDegrees[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}