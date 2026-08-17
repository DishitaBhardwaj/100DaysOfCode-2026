package Day_40;

import java.util.ArrayDeque;
import java.util.Deque;

public class Question2 {
    public int[] HighTemp(int[] temperatures, int k) {
        int n=temperatures.length;
        int []ans=new int[n-k+1];
        Deque<Integer> dq= new ArrayDeque<>();
        for (int i=0; i< temperatures.length;i++){
            while (!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }
            while (!dq.isEmpty() && temperatures[dq.peekLast()]< temperatures[i]){
                dq.pollLast();    
            }
        dq.offerLast(i);
        if(i >= k-1){
            ans[i-k+1]= temperatures[dq.peekFirst()];
        }
        }
        return ans;
    }
}
