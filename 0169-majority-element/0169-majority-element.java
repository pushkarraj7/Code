class Solution {
    public int majorityElement(int[] nums) {
        int maj=0;
        int count=0;
        for(int num:nums){
            if(count==0)
                maj=num;
            if(num==maj)
                count+=1;
            else 
                count-=1;
        }
        return maj;
    }
}