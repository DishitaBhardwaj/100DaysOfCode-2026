import java.util.*;

public class Question2 {

    public static int[] maxSlidingWindow(int[] temperatures, int k) {

        int n = temperatures.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();
        int resultIndex = 0;

        for (int i = 0; i < n; i++) {

            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() &&
                   temperatures[deque.peekLast()] <= temperatures[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                result[resultIndex++] = temperatures[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String temperatureLine = sc.nextLine();
        String kLine = sc.nextLine();

        String numbers = temperatureLine
                .replaceAll("[^0-9-]+", " ")
                .trim();

        String[] parts = numbers.split("\\s+");

        int[] temperatures = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            temperatures[i] = Integer.parseInt(parts[i]);
        }

        int k = Integer.parseInt(
                kLine.replaceAll("[^0-9]", "")
        );

        int[] result = maxSlidingWindow(temperatures, k);

        System.out.print("[");

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");

        sc.close();
    }
}