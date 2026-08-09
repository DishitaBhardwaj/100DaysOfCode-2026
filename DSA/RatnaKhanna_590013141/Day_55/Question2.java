import java.util.*;

public class Main {

    public static long maxPleasure(int[] length, int[] beauty, int k) {
        int n = length.length;

        // Store {length, beauty}
        int[][] songs = new int[n][2];

        for (int i = 0; i < n; i++) {
            songs[i][0] = length[i];
            songs[i][1] = beauty[i];
        }

        // Sort by beauty in descending order
        Arrays.sort(songs, (a, b) -> b[1] - a[1]);

        // Min-heap to keep the selected lengths
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        long sumLength = 0;
        long maxPleasure = 0;

        for (int[] song : songs) {

            int len = song[0];
            int beautyValue = song[1];

            // Add current song
            minHeap.add(len);
            sumLength += len;

            // Keep at most k songs
            if (minHeap.size() > k) {
                sumLength -= minHeap.poll();
            }

            // Current beauty is the minimum beauty
            // among the songs considered
            maxPleasure = Math.max(
                maxPleasure,
                sumLength * beautyValue
            );
        }

        return maxPleasure;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input n
        int n = sc.nextInt();

        int[] length = new int[n];
        int[] beauty = new int[n];

        // Input lengths
        for (int i = 0; i < n; i++) {
            length[i] = sc.nextInt();
        }

        // Input beauty values
        for (int i = 0; i < n; i++) {
            beauty[i] = sc.nextInt();
        }

        // Input k
        int k = sc.nextInt();

        System.out.println(maxPleasure(length, beauty, k));

        sc.close();
    }
}
