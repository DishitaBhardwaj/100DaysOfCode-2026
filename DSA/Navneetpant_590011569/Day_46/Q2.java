class Solution {
    public int maximumPrefixDifferenceScore(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        for (int x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        return (nums.length - 1) * (max - min);
    }
}