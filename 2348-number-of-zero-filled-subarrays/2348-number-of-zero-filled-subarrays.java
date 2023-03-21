class Solution {
    public long zeroFilledSubarray(int[] nums) {
        // int ans=0;
        // int count=0;
        // for(int i=0;i<nums.length;++i){
        //     if(nums[i]==0)
        //         count++;
        //     else{
        //         ans+=(count*(count+1)/2);
        //         count=0;
        //     }
        // }
        // if(count!=0){
        //     ans+=(count*(count+1)/2);
        // }
        // return ans;
        long total=0L;
        long count=0L;
        for(int i:nums){
            if(i==0)
                count++;
            else{
                if(count>0){
                    total+=count*(count+1L) >>1;
                    count=0;
                }
            }
        }
        if(count>0)
            total+=count*(count+1L) >>1;
        return total;
    }
    
}