class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;

        int[] temp = score.clone();
        Arrays.sort(temp);

        HashMap<Integer, String> map = new HashMap<>();

        for (int i = n - 1; i >= 0; i--) {
            int rank = n - i;

            if (rank == 1)
                map.put(temp[i], "Gold Medal");
            else if (rank == 2)
                map.put(temp[i], "Silver Medal");
            else if (rank == 3)
                map.put(temp[i], "Bronze Medal");
            else
                map.put(temp[i], String.valueOf(rank));
        }

        String[] ans = new String[n];

        for (int i = 0; i < n; i++)
            ans[i] = map.get(score[i]);

        return ans;
    }
}