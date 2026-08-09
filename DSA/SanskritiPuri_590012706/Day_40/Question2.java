import java.util.*;

public class Solution {

    public static int[] highestTemperature(int[] temperatures, int k) {
        int n = temperatures.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            // Remove indices that are out of the current window
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

            // Store the maximum for the current window
            if (i >= k - 1) {
                result[i - k + 1] = temperatures[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] ans1 = highestTemperature(
                new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(ans1));

        int[] ans2 = highestTemperature(
                new int[]{9, 11, 8, 5, 7, 10}, 2);
        System.out.println(Arrays.toString(ans2));

        int[] ans3 = highestTemperature(
                new int[]{4, 4, 4, 4}, 2);
        System.out.println(Arrays.toString(ans3));
    }
}
