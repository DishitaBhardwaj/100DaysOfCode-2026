package MinMaxHeap;
import java.util.*;

public class MaxPleasure {

    static long maxPleasure(int[] length, int[] beauty, int k) {

        int n = length.length;

        // Store {length, beauty}
        int[][] songs = new int[n][2];

        for (int i = 0; i < n; i++) {
            songs[i][0] = length[i];
            songs[i][1] = beauty[i];
        }

        // Sort by beauty in descending order
        Arrays.sort(songs, (a, b) -> b[1] - a[1]);

        // Min-heap to keep the k largest lengths
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        long lengthSum = 0;
        long answer = 0;

        for (int i = 0; i < n; i++) {

            int currentLength = songs[i][0];
            int currentBeauty = songs[i][1];

            // Add current song's length
            minHeap.add(currentLength);
            lengthSum += currentLength;

            // We can select at most k songs
            if (minHeap.size() > k) {
                lengthSum -= minHeap.poll();
            }

            // Current beauty is the minimum beauty
            // among the songs currently considered
            long pleasure = lengthSum * currentBeauty;

            answer = Math.max(answer, pleasure);
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] length = {4, 15, 3, 6};
        int[] beauty = {7, 1, 6, 8};
        int k = 3;

        long result = maxPleasure(length, beauty, k);

        System.out.println("Maximum Pleasure = " + result);
    }
}