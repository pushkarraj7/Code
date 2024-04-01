class Solution {
public:
    long long countSubarrays(vector<int>& nums, int k) {
        long long n = nums.size();
        long long m = *max_element(nums.begin(), nums.end());
        long long i =0, j=0, c=0, answer = 0;
        while (j<n) {
            if (nums[j] == m) {
                c++;
            }
            if (c>=k){
                while (c >= k) {
                    answer += n-j;
                    if (nums[i] == m){
                        c--;
                    }
                    i++;
                }
            }
            j++;
        }
        return answer;
    }
};