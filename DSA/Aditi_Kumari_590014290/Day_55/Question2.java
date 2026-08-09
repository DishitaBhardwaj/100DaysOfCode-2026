package Day_55;

import java.util.*;

public class Question2 {
    public static long maxPleasure(int[] length, int[] beauty, int k) {
        int n = length.length;
        int[][] songs = new int[n][2];

        for (int i = 0; i < n; i++) {
            songs[i][0] = beauty[i];
            songs[i][1] = length[i];
        }
        Arrays.sort(songs, (a, b) -> b[0] - a[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int b = songs[i][0];
            int l = songs[i][1];
            pq.add(l);
            sum += l;
            if (pq.size() > k) {
                sum -= pq.poll();
            }
            ans = Math.max(ans, sum * b);
        }
        return ans;
    }
}