import java.util.ArrayDeque;
import java.util.Deque;

public class Problem2 {
    public int[] highestTemperatureInEveryWindow(int[] temperatures, int k) {
        int n = temperatures.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && temperatures[deque.peekLast()] <= temperatures[i]) {
                deque.removeLast();
            }

            deque.addLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = temperatures[deque.peekFirst()];
            }
        }

        return result;
    }
}