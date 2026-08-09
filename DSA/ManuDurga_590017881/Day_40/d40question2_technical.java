package Day_40;

import java.util.*;

public class d40question2_technical {
    public static int[] highestTemperature(int[] temperatures, int k) {
        int n = temperatures.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && temperatures[deque.peekLast()] <= temperatures[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                result[i - k + 1] = temperatures[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Value " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter window size k: ");
        int k = sc.nextInt();

        int[] ans = highestTemperature(arr, k);
        System.out.println("Result: " + Arrays.toString(ans));
        sc.close();
    }
}
