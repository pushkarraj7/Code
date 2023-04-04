class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> l=new LinkedList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){
                int lp=i+1, hp=nums.length-1, sum=0-nums[i];
                while(lp<hp){
                    if(nums[lp]+nums[hp]==sum){
                        l.add(Arrays.asList(nums[i],nums[lp],nums[hp]));
                        while(lp<hp && nums[lp]==nums[lp+1])
                            lp++;
                        while(lp<hp && nums[hp]==nums[hp-1])
                            hp--;
                        lp++;
                        hp--;
                    }
                    else if(nums[lp]+nums[hp]<sum)
                        lp++;
                    else
                        hp--;
                }
            }
        }
        return l;
    }
}