class Solution {
    // Returns the maximum achievable sum of (running max - running min)
    public int maxPrefixDiffSum(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0; // single element => max == min => diff 0

        int max = nums[0], min = nums[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        return (n - 1) * (max - min);
    }

    // Optional: actually construct an optimal arrangement achieving that sum
    public int[] optimalArrangement(int[] nums) {
        int n = nums.length;
        if (n <= 1) return nums;

        int maxIdx = 0, minIdx = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[maxIdx]) maxIdx = i;
            if (nums[i] < nums[minIdx]) minIdx = i;
        }

        int[] result = new int[n];
        result[0] = nums[maxIdx];
        result[1] = nums[minIdx];

        int idx = 2;
        for (int i = 0; i < n; i++) {
            if (i != maxIdx && i != minIdx) {
                result[idx++] = nums[i];
            }
        }
        return result;
    }
}
