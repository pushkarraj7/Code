class Solution {
    public int getWinner(int[] arr, int k) {
        int currentWinner = arr[0];
        int consecutiveWins = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > currentWinner) {
                currentWinner = arr[i];
                consecutiveWins = 1;
            } else {
                consecutiveWins++;
            }

            if (consecutiveWins == k) {
                break;
            }
        }

        return currentWinner;
    }
}