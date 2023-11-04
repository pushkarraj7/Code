class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> operations = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        int num = 1;
        int index = 0;
        
        while (index < target.length) {
            if (num == target[index]) {
                operations.add("Push");
                index++;
            } else {
                operations.add("Push");
                operations.add("Pop");
            }
            num++;
        }
        
        return operations;
    }
}
