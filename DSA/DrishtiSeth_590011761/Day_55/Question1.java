import java.util.*;

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;

        // Store {value, original index}
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        // Sort by value in descending order
        Arrays.sort(arr, (a, b) -> Integer.compare(b[0], a[0]));

        // Select top k elements
        int[][] selected = new int[k][2];

        for (int i = 0; i < k; i++) {
            selected[i] = arr[i];
        }

        // Restore original order
        Arrays.sort(selected, Comparator.comparingInt(a -> a[1]));

        // Create result
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = selected[i][0];
        }

        return result;
    }
}
