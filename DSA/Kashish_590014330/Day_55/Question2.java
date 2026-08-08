import java.util.*;

class Solution {
    public long maxPleasure(int[] length, int[] beauty, int k) {

        int n = length.length;
        int[][] songs = new int[n][2];

        for (int i = 0; i < n; i++) {
            songs[i][0] = length[i];
            songs[i][1] = beauty[i];
        }
        Arrays.sort(songs, (a, b) -> Integer.compare(b[1], a[1]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        long sum = 0;
        long answer = 0;

        for (int i = 0; i < n; i++) {

            int len = songs[i][0];
            int b = songs[i][1];

            sum += len;
            minHeap.add(len);
            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }
            answer = Math.max(answer, sum * b);
        }

        return answer;
    }
}