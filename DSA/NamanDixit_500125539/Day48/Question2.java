
import java.util.Scanner;
import java.util.TreeMap;

public class Question2 {

    // Function to reconstruct any valid array 'a' of length n,
    // given b[] which holds min(a[i], a[j]) for every pair i < j.
    public static int[] reconstructArray(int n, int[] b) {

        // Special case: if there's only 1 element, there are no pairs at all,
        // so ANY single value is a valid answer. We just use 0.
        if (n == 1) {
            return new int[]{0};
        }

        // Step 1: Build a frequency map (multiset) of all values in b.
        // TreeMap keeps keys sorted, so we can always quickly find the
        // CURRENT smallest remaining value using firstKey().
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for (int val : b) {
            // merge() adds 1 to the existing count, or starts at 1 if new
            freq.merge(val, 1, Integer::sum);
        }

        int[] result = new int[n];

        // Step 2: Repeatedly pick the smallest remaining value in the multiset.
        // That value becomes the next element of our reconstructed array.
        for (int k = 0; k < n - 1; k++) {

            // The smallest value currently left in the multiset
            int smallest = freq.firstKey();
            result[k] = smallest;

            // This value must appear paired with every element that comes
            // AFTER it in our array (there are "n - 1 - k" such elements left).
            int needed = n - 1 - k;

            int currentCount = freq.get(smallest);

            if (currentCount > needed) {
                // Still some copies of "smallest" left over for future pairs, so just reduce the count
                freq.put(smallest, currentCount - needed);
            } else {
                // We've used up all copies of "smallest" -- remove it completely
                freq.remove(smallest);
            }
        }

        // Step 3: The LAST element of the array never shows up on its own in b,
        // because every pair involving it was already covered by smaller elements.
        // Any value >= the previous element works. The simplest safe choice
        // is to just reuse the same value as the previous element.
        result[n - 1] = result[n - 2];

        return result;
    }

    // Main method: takes user input and prints the result
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Step 1: Read n (length of the array we want to reconstruct)
        System.out.println("Enter n (length of array a):");
        int n = Integer.parseInt(scanner.nextLine().trim());

        // Step 2: Calculate how many pairwise minimums there should be: n*(n-1)/2
        int bSize = n * (n - 1) / 2;

        int[] b;
        if (bSize == 0) {
            // No pairs to enter if n <= 1
            b = new int[0];
            System.out.println("(n = " + n + ", so there are no pairs -- skipping b input)");
        } else {
            System.out.println("Enter " + bSize + " integers for b (the pairwise minimums), separated by spaces:");
            String[] parts = scanner.nextLine().trim().split("\\s+");
            b = new int[bSize];
            for (int i = 0; i < bSize; i++) {
                b[i] = Integer.parseInt(parts[i]);
            }
        }

        // Step 3: Call the function and print the result
        int[] result = reconstructArray(n, b);

        System.out.print("Reconstructed array a: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        scanner.close();
    }
}
