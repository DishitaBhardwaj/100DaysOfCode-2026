import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] temperatures, int k) {
        int n = temperatures.length;
        int[] ans = new int[n - k + 1];

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // Remove indices outside the current window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove smaller elements from the back
            while (!dq.isEmpty() && temperatures[dq.peekLast()] <= temperatures[i]) {
                dq.pollLast();
            }

            // Add current index
            dq.offerLast(i);

            // Window of size k formed
            if (i >= k - 1) {
                ans[i - k + 1] = temperatures[dq.peekFirst()];
            }
        }

        return ans;
    }
}
