import java.util.*;

class Solution {
    public int maxPrefixDifferenceScore(int[] nums) {
        Arrays.sort(nums);

        ArrayList<Integer> arr = new ArrayList<>();

        int n = nums.length;

        arr.add(nums[n - 1]); // largest
        arr.add(nums[0]); // smallest

        for (int i = 1; i < n - 1; i++)
            arr.add(nums[i]);

        int mn = arr.get(0);
        int mx = arr.get(0);
        int score = 0;

        for (int x : arr) {
            mn = Math.min(mn, x);
            mx = Math.max(mx, x);
            score += (mx - mn);
        }

        return score;
    }
}