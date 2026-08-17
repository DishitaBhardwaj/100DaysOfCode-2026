class Solution {
    public int maximumPrefixDifferenceScore(int[] nums) {

        int min = nums[0];
        int max = nums[0];

        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        return (nums.length - 1) * (max - min);
    }
}