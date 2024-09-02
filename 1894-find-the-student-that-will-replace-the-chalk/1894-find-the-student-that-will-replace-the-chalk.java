class Solution {
    int n;
    public int ceil(long prefixSum [], int remainingChalks){
        int start = 0;
        int end = n-1;
        int ans = 0;
        
        while(start <= end){
            int mid = start + (end-start) / 2;
            if(prefixSum[mid] == remainingChalks){
                return mid + 1;
            } else if(prefixSum[mid] < remainingChalks){
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }
    
    public int chalkReplacer(int[] chalk, int k) {
        n = chalk.length;
        long prefixSum[] = new long [n];
        prefixSum[0] = chalk[0];
        for(int i = 1; i < chalk.length; i++){
            prefixSum[i] = prefixSum[i-1] + chalk[i];
        }
        long sum = prefixSum[n-1];
        int remainingChalks = (int)(k % sum);
        return ceil(prefixSum, remainingChalks);
    }
}