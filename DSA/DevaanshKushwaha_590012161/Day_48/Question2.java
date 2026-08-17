import java.util.*;

class Solution {
    public int[] reconstructArray(int n, int[] b) {
        int[] a = new int[n];

        if (n == 1) {
            a[0] = 1; // no pairs exist, any value is valid
            return a;
        }

        // Count frequency of each value in b
        Map<Integer, Integer> count = new HashMap<>();
        int maxVal = Integer.MIN_VALUE;
        for (int val : b) {
            count.merge(val, 1, Integer::sum);
            maxVal = Math.max(maxVal, val);
        }

        // Distinct values sorted ascending (at most n-1 of them)
        Integer[] sortedVals = count.keySet().toArray(new Integer[0]);
        Arrays.sort(sortedVals);

        int ptr = 0;
        int remaining = n; // elements of a not yet finalized

        for (int i = 0; i < n - 1; i++) {
            // skip values whose count has been fully consumed
            while (ptr < sortedVals.length && count.get(sortedVals[ptr]) == 0) {
                ptr++;
            }
            int x = sortedVals[ptr];
            a[i] = x;

            int need = remaining - 1; // pairs formed between a[i] and unplaced elements
            count.put(x, count.get(x) - need);
            remaining--;
        }

        // Largest element: must exceed every value in b so it never becomes a min
        a[n - 1] = maxVal + 1;
        return a;
    }
}
