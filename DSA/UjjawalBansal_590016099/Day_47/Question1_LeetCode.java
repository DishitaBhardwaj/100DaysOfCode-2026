class Question1_LeetCode {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];
        
        int[][] scoresIndex = new int[n][2];
        for (int i = 0; i < n; i++) {
            scoresIndex[i][0] = score[i];
            scoresIndex[i][1] = i;
        }

        Arrays.sort(scoresIndex, (a, b) -> b[0] - a[0]);
        
        for (int i = 0; i < n; i++) {
            int id = scoresIndex[i][1];
            
            if (i == 0) {
                result[id] = "Gold Medal";
            } 
            else if (i == 1) {
                result[id] = "Silver Medal";
            } 
            else if (i == 2) {
                result[id] = "Bronze Medal";
            } 
            else {
                result[id] = String.valueOf(i + 1);
            }
        }
        return result;
    }
}