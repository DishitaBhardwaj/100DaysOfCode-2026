package DSA.Saransh_590024524.Day40;

import java.util.ArrayDeque;
import java.util.Deque;

public class Question2 {
        public int[] maxSlidingWindow(int[] temperatures, int k) {

        int n = temperatures.length;
        int[] ans = new int[n - k + 1];

        Deque<Integer> dq = new ArrayDeque<>();

        int index = 0;

        for (int i = 0; i < n; i++) {

            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() &&
                   temperatures[dq.peekLast()] <= temperatures[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);

            if (i >= k - 1) {
                ans[index++] = temperatures[dq.peekFirst()];
            }
        }
        return ans;
    }    
}
