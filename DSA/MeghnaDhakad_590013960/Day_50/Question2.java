import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    static int quarrySmasher(int[] rocks) {
        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int rock : rocks)
            pq.offer(rock);

        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();

            if (x != y)
                pq.offer(x - y);
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }

    public static void main(String[] args) {
        int[] rocks = {2, 7, 4, 1, 8, 1};

        System.out.println(quarrySmasher(rocks));
    }
}