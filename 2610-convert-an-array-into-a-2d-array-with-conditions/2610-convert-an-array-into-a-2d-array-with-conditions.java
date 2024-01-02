class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Arrays.sort(nums); // Sort the array to facilitate the creation of distinct rows
        List<List<Integer>> result = new ArrayList<>();
        
        for (int num : nums) {
            boolean added = false;
            
            // Try to add the current number to an existing row
            for (List<Integer> row : result) {
                if (!row.contains(num)) {
                    row.add(num);
                    added = true;
                    break;
                }
            }
            
            // If the number could not be added to any existing row, create a new row
            if (!added) {
                List<Integer> newRow = new ArrayList<>();
                newRow.add(num);
                result.add(newRow);
            }
        }
        
        return result;
    }
}