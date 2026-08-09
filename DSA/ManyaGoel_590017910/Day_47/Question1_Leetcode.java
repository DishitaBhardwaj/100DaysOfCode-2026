class Question1_Leetcode{
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int max = 0;
        for (int s : score) {
            if (s > max) max = s;
        }
        int[] pos = new int[max + 1];
        for (int i = 0; i < n; i++) {
            pos[score[i]] = i + 1; 
        }
        String[] ans = new String[n];
        int rank = 1;
        for (int s = max; s >= 0; s--) {
            if (pos[s] == 0) continue;

            int idx = pos[s] - 1;
            switch (rank) {
                case 1:
                    ans[idx] = "Gold Medal";
                    break;
                case 2:
                    ans[idx] = "Silver Medal";
                    break;
                case 3:
                    ans[idx] = "Bronze Medal";
                    break;
                default:
                    ans[idx] = String.valueOf(rank);
            }
            if (++rank > n) break;
        }
        return ans;
    }
}