import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Question2 {

    public static int[] highestTempInEveryWindow(int[] temperatures, int k) {
        if (temperatures == null || temperatures.length == 0 || k <= 0) {
            return new int[0];
        }
        int n = temperatures.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && temperatures[deque.peekLast()] <= temperatures[i]) {
                deque.pollLast();
            }
            
            deque.offerLast(i);
            
            if (i >= k - 1) {
                ans[i - k + 1] = temperatures[deque.peekFirst()];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the temperatures array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the temperatures: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the size of contiguous windows: ");
        int k = sc.nextInt();

        int[] ans = highestTempInEveryWindow(arr, k);
        System.out.println("Array containing the maximum temperature for every contiguous window of size " + k + ":");
        System.out.println(Arrays.toString(ans));
        sc.close();
    }
}