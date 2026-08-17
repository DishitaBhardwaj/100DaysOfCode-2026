
import java.util.*;
class T{
    public static void main(String[] args){
        int[] tempe= {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        Deque<Integer> dq = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < tempe.length; i++) {
            while(!dq.isEmpty() && dq.peekFirst() <= i - k){
                dq.removeFirst();
            }
            while(!dq.isEmpty() && tempe[dq.peekLast()] <= tempe[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(i >= k - 1){
                result.add(tempe[dq.peekFirst()]);
            }
        }
        System.out.println(result);
    }
}