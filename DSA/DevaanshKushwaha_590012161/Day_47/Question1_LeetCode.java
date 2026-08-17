class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        
        Arrays.sort(idx, (a, b) -> score[b] - score[a]);
        
        String[] answer = new String[n];
        for (int rank = 0; rank < n; rank++) {
            int i = idx[rank];
            if (rank == 0) answer[i] = "Gold Medal";
            else if (rank == 1) answer[i] = "Silver Medal";
            else if (rank == 2) answer[i] = "Bronze Medal";
            else answer[i] = String.valueOf(rank + 1);
        }
        return answer;
    }
}
