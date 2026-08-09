import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = score[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> b[0] - a[0]);

        String[] ans = new String[n];

        for (int i = 0; i < n; i++) {
            int originalIndex = arr[i][1];

            if (i == 0)
                ans[originalIndex] = "Gold Medal";
            else if (i == 1)
                ans[originalIndex] = "Silver Medal";
            else if (i == 2)
                ans[originalIndex] = "Bronze Medal";
            else
                ans[originalIndex] = String.valueOf(i + 1);
        }

        return ans;
    }
}