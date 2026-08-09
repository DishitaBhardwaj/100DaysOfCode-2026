import java.util.*;

public class Question2 {

    public static int[] maxSlidingWindow(int[] temperatures, int k) {
        int n = temperatures.length;
        if (n == 0) return new int[0];

        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>(); 

        for (int i = 0; i < n; i++) {

            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && temperatures[dq.peekLast()] < temperatures[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = temperatures[dq.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] ans = maxSlidingWindow(temperatures, k);

        System.out.println(Arrays.toString(ans));
    }
}