import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int lastStoneWeight(int[] rocks) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int rock : rocks) {
            maxHeap.offer(rock);
        }

        while (maxHeap.size() > 1) {
            int first = maxHeap.poll();  // heaviest
            int second = maxHeap.poll(); // second heaviest
            if (first != second) {
                maxHeap.offer(first - second); // smash: heavier reduced by difference
            }
            // if equal, both are destroyed -> nothing added back
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
