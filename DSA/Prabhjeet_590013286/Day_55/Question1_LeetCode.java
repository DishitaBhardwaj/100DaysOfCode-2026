//Need to find the subsequence of length k with the largest sum

import java.util.*;

class Solution {

    public int[] maxSubsequence(int[] nums, int k) {

        int n = nums.length;

        int[][] arr = new int[n][2];

        // store value and original index
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        // sort by value in descending order
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);

        // keep only the top k elements
        Arrays.sort(arr, 0, k, (a, b) -> a[1] - b[1]);

        int[] ans = new int[k];

        // preserve original order
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i][0];
        }

        return ans;
    }
}