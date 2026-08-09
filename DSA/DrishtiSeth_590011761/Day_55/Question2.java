import java.util.*;

class Solution {
    public long maxPerformance(int[] length, int[] beauty, int k) {

        int n = length.length;

        // Store {beauty, length}
        int[][] songs = new int[n][2];

        for (int i = 0; i < n; i++) {
            songs[i][0] = beauty[i];
            songs[i][1] = length[i];
        }

        // Sort by beauty in descending order
        Arrays.sort(songs, (a, b) -> Integer.compare(b[0], a[0]));

        // Min-heap to keep the largest k lengths
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        long sum = 0;
        long answer = 0;

        for (int[] song : songs) {

            int currentBeauty = song[0];
            int currentLength = song[1];

            // Add current song
            minHeap.offer(currentLength);
            sum += currentLength;

            // Keep at most k songs
            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }

            // Current beauty is the minimum beauty
            answer = Math.max(answer, sum * currentBeauty);
        }

        return answer;
    }
}
