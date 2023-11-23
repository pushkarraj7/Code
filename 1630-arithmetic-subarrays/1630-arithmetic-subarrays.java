class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();

        for (int i = 0; i < l.length; i++) {
            int[] subarray = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(subarray);
            result.add(isArithmeticSequence(subarray));
        }

        return result;
    }

    private boolean isArithmeticSequence(int[] subarray) {
        if (subarray.length < 2) {
            return false;
        }

        int diff = subarray[1] - subarray[0];

        for (int i = 1; i < subarray.length - 1; i++) {
            if (subarray[i + 1] - subarray[i] != diff) {
                return false;
            }
        }

        return true;
    }
}