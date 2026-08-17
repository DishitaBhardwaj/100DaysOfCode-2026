import java.util.*;

class Question2 {
    public long maxPrefixDifferenceScore(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] arr = new int[n];
        arr[0] = nums[n - 1];
        if (n > 1) arr[1] = nums[0];

        int idx = 2;
        for (int i = 1; i < n - 1; i++) {
            arr[idx++] = nums[i];
        }

        long ans = 0;
        int max = arr[0];
        int min = arr[0];

        for (int x : arr) {
            max = Math.max(max, x);
            min = Math.min(min, x);
            ans += (max - min);
        }

        return ans;
    }
}