class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> ng=new HashMap();
        Stack<Integer> stack=new Stack();
        for(Integer num:nums2){
            while(!stack.isEmpty()&& stack.peek()<num)
                ng.put(stack.pop(),num);
            stack.push(num);
        }
        for(int i=0; i<nums1.length;i++)
            nums1[i]=ng.getOrDefault(nums1[i], -1);
        return nums1;
    }
}