class Solution {
    public String[] findRelativeRanks(int[] score) {

        int n = score.length;
        int[] sorted = score.clone();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sorted[j] < sorted[j + 1]) {
                    int temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                }
            }
        }

        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (score[i] == sorted[j]) {

                    if (j == 0)
                        result[i] = "Gold Medal";
                    else if (j == 1)
                        result[i] = "Silver Medal";
                    else if (j == 2)
                        result[i] = "Bronze Medal";
                    else
                        result[i] = Integer.toString(j + 1);

                    break;
                }
            }
        }

        return result;
    }
}