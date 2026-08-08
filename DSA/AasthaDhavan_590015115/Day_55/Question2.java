import java.util.*;

class Question2 {
    public long maxPleasure(int[] length, int[] beauty, int k) {
        int n = length.length;

        // Store {beauty, length}
        int[][] songs = new int[n][2];

        for (int i = 0; i < n; i++) {
            songs[i][0] = beauty[i];
            songs[i][1] = length[i];
        }

        // Sort by beauty descending
        Arrays.sort(songs, (a, b) -> Integer.compare(b[0], a[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;
        long maxPleasure = 0;

        for (int[] song : songs) {
            int b = song[0];
            int len = song[1];

            minHeap.add(len);
            sum += len;

            // Keep at most k songs
            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }

            // Current beauty is the minimum beauty
            // among songs considered in this group
            maxPleasure = Math.max(maxPleasure, sum * b);
        }

        return maxPleasure;
    }
}