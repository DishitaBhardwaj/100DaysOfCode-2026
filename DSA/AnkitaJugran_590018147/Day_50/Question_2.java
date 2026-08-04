package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class QuarrySmasher {

    public static void main(String[] args) {

        int[] stones = {2, 7, 4, 1, 8, 1};
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            //inserting all stones into maxHeap
            maxHeap.offer(stone);
        }

        while( maxHeap.size() > 1 ) {

            //first two largest stones are removed from the heap
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            //if both doesn.t have equal weight, the difference is added back to the heap
            if ( stone1 != stone2 ) {

                maxHeap.offer( stone1 - stone2 );
            }
        }

        if ( maxHeap.isEmpty() ) {
            
            System.out.println(0);
        }
        else {
            System.out.println( maxHeap.poll() );
            
        }
        
    }
    
}
