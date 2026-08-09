import java.util.*;

class Solution {
    public long maxPleasure(int[] length, int[] beauty, int k) {
        int n = length.length;

        // Step 1: pair (beauty, length)
        int[][] songs = new int[n][2];
        for (int i = 0; i < n; i++) {
            songs[i][0] = beauty[i];
            songs[i][1] = length[i];
        }

        // Step 2: sort by beauty DESC
        Arrays.sort(songs, (a, b) -> b[0] - a[0]);

        // Step 3: min heap for lengths
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sumLength = 0;
        long maxPleasure = 0;

        // Step 4: iterate
        for (int[] song : songs) {
            int b = song[0];
            int l = song[1];

            minHeap.add(l);
            sumLength += l;

            // keep only k songs
            if (minHeap.size() > k) {
                sumLength -= minHeap.poll();
            }

            // calculate pleasure
            maxPleasure = Math.max(maxPleasure, sumLength * b);
        }

        return maxPleasure;
    }
}