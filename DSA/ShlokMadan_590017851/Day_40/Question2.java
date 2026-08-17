import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Question2 {

    public static int[] maxSlidingWindow(int[] temperatures,int k) {

        Deque<Integer> dq=new ArrayDeque<>();
        int[] ans=new int[temperatures.length-k+1];
        int index=0;

        for(int i=0;i<temperatures.length;i++) {

            while(!dq.isEmpty() && dq.peekFirst()<=i-k) {
                dq.pollFirst();
            }

            while(!dq.isEmpty() && temperatures[dq.peekLast()]<=temperatures[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            if(i>=k-1) {
                ans[index++]=temperatures[dq.peekFirst()];
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] temperatures={1,3,-1,-3,5,3,6,7};
        int k=3;

        System.out.println(Arrays.toString(maxSlidingWindow(temperatures,k)));
    }
}