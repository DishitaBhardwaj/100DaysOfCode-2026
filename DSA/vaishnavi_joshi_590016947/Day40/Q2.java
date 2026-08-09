import java.util.*;

public class Main {

    public static int[] maxSlidingWindow(int[] temperatures, int k) {

        if (temperatures == null || temperatures.length == 0 || k == 0) {
            return new int[0];
        }

        int n = temperatures.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            // Remove indices outside the current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove smaller elements from the back
            while (!deque.isEmpty() &&
                    temperatures[deque.peekLast()] <= temperatures[i]) {
                deque.pollLast();
            }

            // Add current index
            deque.offerLast(i);

            // Store maximum for current window
            if (i >= k - 1) {
                result[i - k + 1] = temperatures[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of temperatures: ");
        int n = sc.nextInt();

        int[] temperatures = new int[n];

        System.out.println("Enter temperature values:");
        for (int i = 0; i < n; i++) {
            temperatures[i] = sc.nextInt();
        }

        System.out.print("Enter window size (k): ");
        int k = sc.nextInt();

        int[] ans = maxSlidingWindow(temperatures, k);

        System.out.println("Maximum temperature in each window:");

        for (int value : ans) {
            System.out.print(value + " ");
        }

        sc.close();
    }
}