import java.util.Collections;
import java.util.PriorityQueue;

public class Q2 {

    public static int lastStoneWeight(int[] rocks) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int rock : rocks) {
            maxHeap.offer(rock);
        }

        while (maxHeap.size() > 1) {
            int heavy1 = maxHeap.poll(); 
            int heavy2 = maxHeap.poll(); 

            if (heavy1 != heavy2) {
                maxHeap.offer(heavy1 - heavy2);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
    
    public static void main(String[] args) {
        int[] rocks = {2, 7, 4, 1, 8, 1};
        System.out.println("Output: " + lastStoneWeight(rocks));
    }
}