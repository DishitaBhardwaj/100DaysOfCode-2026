
import java.util.Arrays;

public class Question2 {

    // Function to maximize the sum of pair minimums
    public static int maxSumOfPairMinimums(int[] arr) {

        // Step 1: Sort the array in ascending order.
        // After sorting, pairing each element with its neighbor
        // guarantees the smallest possible numbers are "wasted"
        // as the maximum of each pair.
        Arrays.sort(arr);

        int sum = 0;

        // Step 2: Pick every element at an EVEN index (0, 2, 4, ...).
        // Because the array is sorted, arr[i] will always be the
        // smaller number in the pair (arr[i], arr[i+1]).
        for (int i = 0; i < arr.length; i += 2) {
            sum += arr[i];
        }

        return sum;
    }

    // Main method to test the function
    public static void main(String[] args) {

        // Example input: 2n integers, here n = 2, so 4 integers
        int[] arr = {1, 4, 3, 2};

        // Call the function and print the result
        int result = maxSumOfPairMinimums(arr);

        System.out.println("Maximum sum of pair minimums: " + result);
    }
}