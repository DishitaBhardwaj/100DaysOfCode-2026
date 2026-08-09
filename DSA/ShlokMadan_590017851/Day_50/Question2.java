import java.util.Collections;
import java.util.PriorityQueue;

public class Question2 {

    public static int lastRockWeight(int[] rocks) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int rock : rocks) {
            maxHeap.offer(rock);
        }

        while (maxHeap.size() > 1) {

            int first = maxHeap.poll();
            int second = maxHeap.poll();

            if (first != second) {
                maxHeap.offer(first - second);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    public static void main(String[] args) {

        int[] rocks = {2, 7, 4, 1, 8, 1};

        System.out.println(lastRockWeight(rocks));
    }
}