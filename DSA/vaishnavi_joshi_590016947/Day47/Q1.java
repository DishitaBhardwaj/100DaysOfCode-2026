import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;

        // Copy the scores and sort them
        int[] sorted = score.clone();
        Arrays.sort(sorted);

        // Store rank of each score
        HashMap<Integer, Integer> rankMap = new HashMap<>();

        int rank = 1;
        for (int i = n - 1; i >= 0; i--) {
            rankMap.put(sorted[i], rank++);
        }

        // Prepare answer
        String[] ans = new String[n];

        for (int i = 0; i < n; i++) {
            int r = rankMap.get(score[i]);

            if (r == 1) {
                ans[i] = "Gold Medal";
            } else if (r == 2) {
                ans[i] = "Silver Medal";
            } else if (r == 3) {
                ans[i] = "Bronze Medal";
            } else {
                ans[i] = String.valueOf(r);
            }
        }

        return ans;
    }
}