public class Problem2 {
    public int maximumPrefixDifferenceScore(int[] nums) {
        int minimum = nums[0];
        int maximum = nums[0];

        for (int num : nums) {
            if (num < minimum) {
                minimum = num;
            }
            if (num > maximum) {
                maximum = num;
            }
        }

        return (nums.length - 1) * (maximum - minimum);
    }
}