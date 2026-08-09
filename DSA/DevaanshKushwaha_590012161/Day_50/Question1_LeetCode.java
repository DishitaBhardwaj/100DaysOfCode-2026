class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for (int op = 0; op < k; op++) {
            int minIdx = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[minIdx]) {
                    minIdx = i;
                }
            }
            nums[minIdx] *= multiplier;
        }
        return nums;
    }
}
