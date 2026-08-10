
import java.util.*;
class MPP{
    public static long maxPleasure(int[] length, int[] beauty, int k) {
        int n = length.length;
        int[][] songs = new int[n][2];
        for (int i = 0; i < n; i++) {
            songs[i][0] = length[i];
            songs[i][1] = beauty[i];
        }
        Arrays.sort(songs, (a, b) -> b[1] - a[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sumLength = 0;
        long answer = 0;
        for (int[] song : songs) {
            int len = song[0];
            int beautyValue = song[1];
            pq.add(len);
            sumLength += len;
            if (pq.size() > k) {
                sumLength -= pq.poll();
            }
            long pleasure = sumLength * beautyValue;
            answer = Math.max(answer, pleasure);
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] length = {4, 15, 3, 6};
        int[] beauty = {7, 1, 6, 8};
        int k = 3;
        System.out.println("Maximum Playlist Pleasure:"
                + maxPleasure(length, beauty, k));
    }
}