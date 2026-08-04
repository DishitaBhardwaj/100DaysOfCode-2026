import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int lastStoneWeight(int[] rocks) {

        // Max Heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all rocks to the heap
        for (int rock : rocks) {
            maxHeap.offer(rock);
        }

        // Smash the two heaviest rocks
        while (maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();

            if (first != second) {
                maxHeap.offer(first - second);
            }
        }

        // Return remaining rock or 0
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}