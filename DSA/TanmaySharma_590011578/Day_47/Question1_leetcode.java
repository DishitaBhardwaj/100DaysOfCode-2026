package DSA.TanmaySharma_590011578.Day_47;
import java.util.Arrays;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];

        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> Integer.compare(score[b], score[a]));

        for (int rank = 0; rank < n; rank++) {
            int originalIndex = indices[rank];

            if (rank == 0) {
                result[originalIndex] = "Gold Medal";
            } else if (rank == 1) {
                result[originalIndex] = "Silver Medal";
            } else if (rank == 2) {
                result[originalIndex] = "Bronze Medal";
            } else {
                result[originalIndex] = String.valueOf(rank + 1);
            }
        }

        return result;
    }
}