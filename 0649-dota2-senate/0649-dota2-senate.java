class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        int n = senate.length();
        for (int i = 0; i < n; i++) {
            char c = senate.charAt(i);
            if (c == 'R') {
                q1.offer(i);
            } else {
                q2.offer(i);
            }
        }
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int rIndex = q1.poll(), dIndex = q2.poll();
            if (rIndex < dIndex) {
                q1.offer(rIndex + n);
            } else {
                q2.offer(dIndex + n);
            }
        }
        return q1.isEmpty() ? "Dire" : "Radiant";
    }
}