import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Question2 {
    public static long maxPlaylistPleasure(int[] length, int[] beauty, int k) {
        int n = length.length;

        int[][] songs = new int[n][2];
        for (int i = 0; i < n; i++) {
            songs[i][0] = length[i];
            songs[i][1] = beauty[i];
        }
        
        Arrays.sort(songs, (a, b) -> Integer.compare(b[1], a[1]));
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long ans = 0;
        long curr = 0;
        
        for (int[] song : songs) {
            int currLen = song[0];
            int currBeauty = song[1];
            
            minHeap.offer(currLen);
            curr += currLen;
            
            if (minHeap.size() > k) {
                curr -= minHeap.poll();
            }
            
            long currentPleasure = curr * currBeauty;
            ans = Math.max(ans, currentPleasure);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total number of songs: ");
        int n = sc.nextInt();
            
        int[] length = new int[n];
        System.out.println("Enter the lengths of the " + n + " songs:");
        for (int i = 0; i < n; i++) {
            length[i] = sc.nextInt();
        }
            
        int[] beauty = new int[n];
        System.out.println("Enter the beauty ratings of the " + n + " songs:");
        for (int i = 0; i < n; i++) {
            beauty[i] = sc.nextInt();
        }
            
        System.out.println("Enter the maximum number of songs to select (k): ");
        int k = sc.nextInt();
            
        long result = maxPlaylistPleasure(length, beauty, k);
        System.out.println("Maximum possible pleasure: " + result);
            
        sc.close();
    }
}