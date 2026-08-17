import java.util.*;

class Solution {

    public long maximumPrefixDifferenceScore(int[] arr) {
        int n = arr.length;
        if (n <= 1)
            return 0;

        Arrays.sort(arr);

        List<Integer> a = new ArrayList<>();
        a.add(arr[0]);
        a.add(arr[n - 1]);

        for (int i = 1; i < n - 1; i++) {
            a.add(arr[i]);
        }
        int rMin = a.get(0);
        int rMax = a.get(0);
        long score = 0;

        for (int x : a) {
            rMin = Math.min(rMin, x);
            rMax = Math.max(rMax, x);
            score += (rMax - rMin);
        }

        return score;
    }
}