package Day55;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Question2 {
    public long maximumPlaylistPleasure(int[] length, int[] beauty, int k) {
        int n = length.length;
        int[][] songs = new int[n][2];

        for (int i = 0; i < n; i++) {
            songs[i][0] = beauty[i];
            songs[i][1] = length[i];
        }

        Arrays.sort(songs, (a, b) -> Integer.compare(b[0], a[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sumLengths = 0;
        long bestPleasure = 0;

        for (int[] song : songs) {
            minHeap.offer(song[1]);
            sumLengths += song[1];

            if (minHeap.size() > k) {
                sumLengths -= minHeap.poll();
            }

            bestPleasure = Math.max(bestPleasure, sumLengths * song[0]);
        }

        return bestPleasure;
    }
}