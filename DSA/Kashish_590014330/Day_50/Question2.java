import java.util.*;

class Solution {
    public int lastStoneWeight(int[] rocks) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int rock : rocks) {
            pq.offer(rock);
        }
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            if (first != second) {
                pq.offer(first - second);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}