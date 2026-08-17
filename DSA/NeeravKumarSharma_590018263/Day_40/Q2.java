import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Q2 {

    public static void main(String[] args) {
        int[] temperatures = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(temperatures, k);
        System.out.println("Output: " + Arrays.toString(result));
    }

    public static int[] maxSlidingWindow(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return new int[0];
        }

        int n = arr.length;
        int[] result = new int[n - k + 1];
        int resultIndex = 0;

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                result[resultIndex++] = arr[deque.peekFirst()];
            }
        }

        return result;
    }
}