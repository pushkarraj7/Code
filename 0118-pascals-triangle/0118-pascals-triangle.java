class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        if(numRows==0)
            return result;
        result.add(new ArrayList<>());
        result.get(0).add(1);
        for(int i=1;i<numRows;i++){
            List<Integer> curr=new ArrayList<>();
            curr.add(1);
            for(int j=1;j<i;j++)
                curr.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
            curr.add(1);
            result.add(curr);
        }
        return result;
    }
}