
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Question2 {

    // Function to find maximum in every window
    public static int[] maxSlidingWindow(int[] arr, int k) {

        int n = arr.length;

        // Result array
        int[] result = new int[n - k + 1];

        // Deque stores indices
        Deque<Integer> deque = new LinkedList<>();

        // Index for result array
        int index = 0;

        // Traverse array
        for (int i = 0; i < n; i++) {

            // Remove indices outside the current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove all smaller elements from the back
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }

            // Add current index
            deque.offerLast(i);

            // Window of size k is ready
            if (i >= k - 1) {

                // Front of deque has maximum element
                result[index++] = arr[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter number of temperatures: ");
        int n = sc.nextInt();

        int[] temperatures = new int[n];

        // Input temperatures
        System.out.println("Enter temperatures:");

        for (int i = 0; i < n; i++) {
            temperatures[i] = sc.nextInt();
        }

        // Input window size
        System.out.print("Enter window size (k): ");
        int k = sc.nextInt();

        // Find maximums
        int[] answer = maxSlidingWindow(temperatures, k);

        // Print result
        System.out.println("Maximum temperature in every window:");

        for (int value : answer) {
            System.out.print(value + " ");
        }

        sc.close();
    }
}
