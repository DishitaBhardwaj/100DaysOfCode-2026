import java.util.Collections;
import java.util.PriorityQueue;

public class Question2 {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int y = pq.poll(); // largest
            int x = pq.poll(); // second largest

            if (y != x) {
                pq.offer(y - x);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
