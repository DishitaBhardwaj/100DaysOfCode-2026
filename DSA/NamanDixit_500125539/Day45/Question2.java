import java.util.Scanner;

public class Question2{

    // This variable will keep track of the total number of inversions found.
    // It's declared at the class level so all recursive calls can update it.
    static long inversionCount = 0;

    // Main entry point: merge sort the array while counting inversions along the way
    public static long countInversions(int[] arr) {
        inversionCount = 0; // reset before starting

        // We need a temporary array to help with merging (standard merge sort requirement)
        int[] temp = new int[arr.length];

        // Start the recursive merge sort over the whole array (from index 0 to length-1)
        mergeSort(arr, temp, 0, arr.length - 1);

        return inversionCount;
    }

    // Recursively splits the array into halves, sorts each half,
    // and merges them back together while counting inversions.
    private static void mergeSort(int[] arr, int[] temp, int left, int right) {

        // Base case: a single element (or empty range) is already "sorted"
        // and has no inversions, so nothing to do.
        if (left >= right) {
            return;
        }

        // Find the middle point to split the array into two halves
        int mid = left + (right - left) / 2;

        // Recursively sort the left half
        mergeSort(arr, temp, left, mid);

        // Recursively sort the right half
        mergeSort(arr, temp, mid + 1, right);

        // Merge the two sorted halves back together, counting inversions
        merge(arr, temp, left, mid, right);
    }

    // Merges two sorted halves: arr[left..mid] and arr[mid+1..right]
    // While merging, counts how many inversions exist between the two halves.
    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {

        // Copy the current range into a temp array so we can safely overwrite arr[]
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;      // pointer for the left half (starts at "left")
        int j = mid + 1;   // pointer for the right half (starts right after "mid")
        int k = left;      // pointer for where we write back into arr[]

        // Step 1: Compare elements from both halves and place the smaller one into arr[]
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                // No inversion here: left element is smaller or equal, so it belongs first
                arr[k] = temp[i];
                i++;
            } else {
                // temp[i] > temp[j] means:
                // Since the left half (temp[i..mid]) is already sorted,
                // EVERY remaining element from i to mid is also greater than temp[j].
                // That means all of them form an inversion with temp[j].
                arr[k] = temp[j];
                j++;

                // Add all those inversions at once (this is the key efficiency trick!)
                inversionCount += (mid - i + 1);
            }
            k++;
        }

        // Step 2: Copy any remaining elements from the left half (no more inversions possible here)
        while (i <= mid) {
            arr[k] = temp[i];
            i++;
            k++;
        }

        // Step 3: Copy any remaining elements from the right half (no more inversions possible here)
        while (j <= right) {
            arr[k] = temp[j];
            j++;
            k++;
        }
    }

    // Main method: takes user input and prints the inversion count
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array:");
        int n = Integer.parseInt(scanner.nextLine().trim());

        int[] arr = new int[n];

        System.out.println("Enter " + n + " integers separated by spaces:");
        String[] parts = scanner.nextLine().trim().split("\\s+");

        // Convert each input string into an integer and store it in arr[]
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        // Call our function to count inversions
        long result = countInversions(arr);

        // Print the result
        System.out.println("Number of inversions: " + result);

        scanner.close();
    }
}