import java.util.*;

public class Question2 {

    public static long maxPleasure(int[] length, int[] beauty, int k) {

        int n = length.length;

        // Store {beauty, length}
        int[][] songs = new int[n][2];

        for (int i = 0; i < n; i++) {
            songs[i][0] = beauty[i];
            songs[i][1] = length[i];
        }

        // Sort by beauty in descending order
        Arrays.sort(songs, (a, b) -> Integer.compare(b[0], a[0]));

        // Min-heap for selected song lengths
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        long sumLength = 0;
        long maxPleasure = 0;

        for (int[] song : songs) {

            int currentBeauty = song[0];
            int currentLength = song[1];

            minHeap.offer(currentLength);
            sumLength += currentLength;

            // Keep at most k songs
            if (minHeap.size() > k) {
                sumLength -= minHeap.poll();
            }

            long pleasure = sumLength * currentBeauty;

            maxPleasure = Math.max(maxPleasure, pleasure);
        }

        return maxPleasure;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] length = new int[n];
        int[] beauty = new int[n];

        for (int i = 0; i < n; i++) {
            length[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            beauty[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(maxPleasure(length, beauty, k));

        sc.close();
    }
}