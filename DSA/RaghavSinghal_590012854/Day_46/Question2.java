import java.util.*;

class Solution {

    public int maximumPrefixDifferenceScore(int[] nums) {
        int n = nums.length;

        if (n <= 1) return 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        // Maximum possible score
        return (n - 1) * (max - min);
    }

    public int[] rearrange(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        ans[0] = max;
        ans[1] = min;

        int idx = 2;
        boolean maxUsed = false, minUsed = false;

        for (int x : nums) {
            if (x == max && !maxUsed) {
                maxUsed = true;
            } else if (x == min && !minUsed) {
                minUsed = true;
            } else {
                ans[idx++] = x;
            }
        }

        return ans;
    }
}