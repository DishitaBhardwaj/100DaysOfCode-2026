class Solution {
    public String[] findRelativeRanks(int[] score) {

        String[] answer = new String[score.length];

        // Copy the array
        int[] sorted = score.clone();

        Arrays.sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>();

        int rank = 1;

        // Traverse from highest score to lowest
        for (int i = score.length - 1; i >= 0; i--) {
            map.put(sorted[i], rank);
            rank++;
        }

        // Prepare answer
        for (int i = 0; i < score.length; i++) {

            int r = map.get(score[i]);

            if (r == 1) {
                answer[i] = "Gold Medal";
            } else if (r == 2) {
                answer[i] = "Silver Medal";
            } else if (r == 3) {
                answer[i] = "Bronze Medal";
            } else {
                answer[i] = String.valueOf(r);
            }
        }

        return answer;
    }

    // Main function for testing
    public static void main(String[] args) {

        Solution obj = new Solution();

        int[] score = {10, 3, 8, 9, 4};

        String[] result = obj.findRelativeRanks(score);

        System.out.println(Arrays.toString(result));
        
    }
}