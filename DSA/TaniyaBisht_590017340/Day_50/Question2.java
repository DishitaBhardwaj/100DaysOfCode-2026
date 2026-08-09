
import java.util.*;
class QS{
    public static int lastStoneWeight(int[] rocks){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int rock : rocks){
            pq.add(rock);
        }
        while(pq.size() > 1){
            int first = pq.poll();  
            int second = pq.poll(); 
            if(first != second){
                pq.add(first - second);
            }
        }
        if (pq.isEmpty()){
            return 0;
        }
        return pq.poll();
    }
    public static void main(String[] args){
        int[] rocks = {2, 7, 4, 1, 8, 2};
        System.out.println("Last Stone Weight= " + lastStoneWeight(rocks));
    }
}