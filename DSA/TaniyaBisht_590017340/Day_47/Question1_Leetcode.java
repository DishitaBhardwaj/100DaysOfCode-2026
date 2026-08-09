
class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];
        Map<Integer, Integer> scoreIndexMap = new HashMap<>();
        for(int i=0; i<n; i++){
            scoreIndexMap.put(score[i], i);
        }
        int maxScore= Integer.MIN_VALUE;
        for(int s : score){
            maxScore = Math.max(maxScore, s);
        }
        int rank =1;
        for(int i= maxScore; i>=0; i--){
            if(scoreIndexMap.containsKey(i)){
                int index = scoreIndexMap.get(i);
                if(rank ==1){
                    result[index] = "Gold Medal";
                }
                else if(rank ==2){
                    result[index] = "Silver Medal";
                }
                else if(rank ==3){
                    result[index] = "Bronze Medal";
                }
                else{
                    result[index] = String.valueOf(rank);
                }
                rank++;
            }
        }
        return result;
    }
}