class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {

        int n = score.length;

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (score[j][k] > score[maxIndex][k]) {
                    maxIndex = j;
                }
            }

            int[] temp = score[i];
            score[i] = score[maxIndex];
            score[maxIndex] = temp;
        }

        return score;
    }
}