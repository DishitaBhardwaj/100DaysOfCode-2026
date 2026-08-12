import java.util.*;

class Solution {
    public long maxPleasure(int[][] songs, int k) {
    
        Arrays.sort(songs, (a, b) -> b[1] - a[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long sum = 0;
        long ans = 0;

        for (int[] song : songs) {
            int length = song[0];
            int beauty = song[1];

            pq.add(length);
            sum += length;

            if (pq.size() > k) {
                sum -= pq.poll();
            }

         
            ans = Math.max(ans, sum * beauty);
        }

        return ans;
    }
}
