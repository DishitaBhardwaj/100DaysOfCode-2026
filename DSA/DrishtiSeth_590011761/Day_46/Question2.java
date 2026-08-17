import java.util.Arrays;

class Solution {

    public long maximumPrefixDifferenceScore(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;

        if (n == 1)
            return 0;

        int[] arr = new int[n];

        arr[0] = nums[0];
        arr[1] = nums[n - 1];

        int left = 1;
        int right = n - 2;
        int index = 2;

        while (left <= right) {

            if (left <= right)
                arr[index++] = nums[left++];

            if (left <= right)
                arr[index++] = nums[right--];
        }

        long score = 0;

        int min = arr[0];
        int max = arr[0];

        for (int value : arr) {
            min = Math.min(min, value);
            max = Math.max(max, value);
            score += (max - min);
        }

        return score;
    }
}
