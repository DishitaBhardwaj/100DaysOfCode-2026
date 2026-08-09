//Need to give ranks based on the scores without losing original positions

import java.util.Arrays;

class Solution {

    public String[] findRelativeRanks(int[] score) {

        int n = score.length;
        Integer[] order = new Integer[n];

        for (int i = 0; i < n; i++) {
            order[i] = i;
        }

        // sort the indexes based on their scores
        Arrays.sort(order, (a, b) -> Integer.compare(score[b], score[a]));

        String[] answer = new String[n];

        for (int rank = 0; rank < n; rank++) {

            int index = order[rank];

            if (rank == 0) {
                answer[index] = "Gold Medal";
            }
            else if (rank == 1) {
                answer[index] = "Silver Medal";
            }
            else if (rank == 2) {
                answer[index] = "Bronze Medal";
            }
            else {
                answer[index] = String.valueOf(rank + 1);
            }
        }

        return answer;
    }
}