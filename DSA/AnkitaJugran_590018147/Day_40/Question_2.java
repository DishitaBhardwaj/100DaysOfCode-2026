package Queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class HighestTemp {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] ans = new int[n - k + 1];

        Deque<Integer> dq = new ArrayDeque<>();
        int index = 0;

        for (int i = 0; i < n; i++) {

            // Remove elements outside the current window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove smaller elements from the back
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // Add current index
            dq.offerLast(i);

            // Store answer once first window is formed
            if (i >= k - 1) {
                ans[index++] = nums[dq.peekFirst()];
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] temperatures = {9, 11, 8, 5, 7, 10};
        int k = 2;

        int[] ans = maxSlidingWindow(temperatures, k);

        System.out.println(Arrays.toString(ans));
    }
}