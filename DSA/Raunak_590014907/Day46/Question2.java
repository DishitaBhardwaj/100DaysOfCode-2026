import java.util.Arrays;

class Solution {

    public long maximumPrefixDifferenceScore(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;
        int[] arr = new int[n];

        int left = 0;
        int right = n - 1;
        int idx = 0;

        while (left <= right) {
            arr[idx++] = nums[right--];

            if (left <= right) {
                arr[idx++] = nums[left++];
            }
        }

        int runningMax = arr[0];
        int runningMin = arr[0];

        long score = 0;

        for (int x : arr) {
            runningMax = Math.max(runningMax, x);
            runningMin = Math.min(runningMin, x);
            score += (runningMax - runningMin);
        }

        return score;
    }
}