import java.util.*;

class Question2 {
    public static int[] maxSlidingWindow(int[] temperatures, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[temperatures.length - k + 1];
        int idx = 0;

        for (int i = 0; i < temperatures.length; i++) {
            while (!dq.isEmpty() && dq.peek() <= i - k)
                dq.poll();

            while (!dq.isEmpty() && temperatures[dq.peekLast()] <= temperatures[i])
                dq.pollLast();

            dq.offer(i);

            if (i >= k - 1)
                ans[idx++] = temperatures[dq.peek()];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] temperatures = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        System.out.println(Arrays.toString(maxSlidingWindow(temperatures, k)));
    }
}