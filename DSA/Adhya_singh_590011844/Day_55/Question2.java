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
        Arrays.sort(songs, (a, b) -> Integer.compare(b[1], a[1]));

        // Min-heap storing selected song lengths
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        long sumLength = 0;
        long maxPleasure = 0;

        for (int[] song : songs) {
            int len = song[0];
            int currentBeauty = song[1];

            // Add current song
            minHeap.offer(len);
            sumLength += len;

            // Keep at most k songs
            if (minHeap.size() > k) {
                sumLength -= minHeap.poll();
            }

            // Current beauty is the minimum beauty
            long pleasure = sumLength * currentBeauty;

            maxPleasure = Math.max(maxPleasure, pleasure);
        }

        return maxPleasure;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of songs: ");
        int n = sc.nextInt();

        int[] length = new int[n];
        int[] beauty = new int[n];

        System.out.println("Enter song lengths:");
        for (int i = 0; i < n; i++) {
            length[i] = sc.nextInt();
        }

        System.out.println("Enter beauty values:");
        for (int i = 0; i < n; i++) {
            beauty[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        long answer = maxPleasure(length, beauty, k);

        System.out.println("Maximum Pleasure: " + answer);

        sc.close();
    }
}
