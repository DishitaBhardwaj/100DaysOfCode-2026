class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        Integer[] index = new Integer[n];

        for(int i = 0; i < n; i++) 
        {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> Integer.compare(score[b], score[a]));
        String[] answer = new String[n];
        for(int i = 0; i < n; i++) 
        {
            int originalIndex = index[i];
            if(i == 0) 
            {
                answer[originalIndex] = "Gold Medal";
            }
            else if(i == 1) 
            {
                answer[originalIndex] = "Silver Medal";
            }
            else if(i == 2) 
            {
                answer[originalIndex] = "Bronze Medal";
            }
            else 
            {
                answer[originalIndex] = String.valueOf(i + 1);
            }
        }
        return answer;
    }
}