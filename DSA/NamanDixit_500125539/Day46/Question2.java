
import java.util.Scanner;

public class Question2 {

    // Function to compute the maximum possible sum of (running max - running min)
    // across all prefixes, after optimally rearranging the array.
    public static long maxPrefixDifferenceScore(int[] arr) {

        int n = arr.length;

        // Step 1: Find the overall maximum and minimum values in the array.
        // We only need these two values -- no actual sorting or rearranging required!
        int maxVal = arr[0];
        int minVal = arr[0];

        for (int num : arr) {
            if (num > maxVal) {
                maxVal = num; // found a new maximum
            }
            if (num < minVal) {
                minVal = num; // found a new minimum
            }
        }

        // Step 2: Apply the formula.
        // The first prefix (1 element) always contributes 0.
        // Every prefix from the 2nd element onward can be made to contribute
        // exactly (maxVal - minVal), by placing the min and max within
        // the first two positions of the rearranged array.
        // That gives (n - 1) prefixes each contributing (maxVal - minVal).
        long difference = maxVal - minVal;
        long result = (long) (n - 1) * difference;

        return result;
    }

    // Main method: takes user input and prints the result
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Step 1: Read the number of elements
        System.out.println("Enter the number of elements in the array:");
        int n = Integer.parseInt(scanner.nextLine().trim());

        // Step 2: Read the array elements
        System.out.println("Enter " + n + " integers separated by spaces:");
        String[] parts = scanner.nextLine().trim().split("\\s+");

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        // Step 3: Call the function and print the result
        long result = maxPrefixDifferenceScore(arr);

        System.out.println("Maximum prefix difference score: " + result);

        scanner.close();
    }
}
