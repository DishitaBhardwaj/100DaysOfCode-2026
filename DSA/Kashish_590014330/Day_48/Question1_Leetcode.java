 class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {

        int m = score.length;

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < m - i - 1; j++) {

                if (score[j][k] < score[j + 1][k]) {

                    int[] temp = score[j];
                    score[j] = score[j + 1];
                    score[j + 1] = temp;
                }
            }
        }

        return score;
    }
}