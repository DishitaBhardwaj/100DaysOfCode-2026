class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] answer = new String[n];

        int[][] athletes = new int[n][2];

        for (int i = 0; i < n; i++) {
            athletes[i][0] = score[i];
            athletes[i][1] = i;
        }

        java.util.Arrays.sort(athletes, (a, b) -> b[0] - a[0]);

        for (int i = 0; i < n; i++) {
            int index = athletes[i][1];

            if (i == 0) {
                answer[index] = "Gold Medal";
            } else if (i == 1) {
                answer[index] = "Silver Medal";
            } else if (i == 2) {
                answer[index] = "Bronze Medal";
            } else {
                answer[index] = String.valueOf(i + 1);
            }
        }

        return answer;
        
    }
}
