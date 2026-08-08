import java.util.*;

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;

        // Step 1: store value + index
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i]; // value
            arr[i][1] = i;       // index
        }

        // Step 2: sort by value descending
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);

        // Step 3: take top k elements
        int[][] topK = Arrays.copyOfRange(arr, 0, k);

        // Step 4: sort selected elements by index
        Arrays.sort(topK, (a, b) -> a[1] - b[1]);

        // Step 5: build result
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topK[i][0];
        }

        return result;
    }
}s