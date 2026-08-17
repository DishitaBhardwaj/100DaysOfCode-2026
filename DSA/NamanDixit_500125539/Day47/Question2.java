import java.util.Scanner;

public class Question2 {

    // Function to find the k-th smallest element (1-indexed) across two sorted arrays,
    // using binary search on partitions instead of merging the arrays.
    public static int findKthSmallest(int[] A, int[] B, int k) {

        // Step 1: Make sure A is the SMALLER array.
        // This isn't required for correctness, but it keeps the binary search
        // range smaller and more efficient. If A is bigger, just swap roles.
        if (A.length > B.length) {
            return findKthSmallest(B, A, k);
        }

        int m = A.length;
        int n = B.length;

        // Step 2: Set up the binary search range for "how many elements to take from A".
        // We must take at least (k - n) elements from A (in case B alone can't cover the rest),
        // and at most min(k, m) elements from A (can't take more than A has, or more than k total).
        int low = Math.max(0, k - n);
        int high = Math.min(k, m);

        while (low <= high) {

            // i = number of elements taken from A's left part
            int i = low + (high - low) / 2;

            // j = number of elements taken from B's left part
            // (together, i + j must always equal k)
            int j = k - i;

            // Step 3: Identify the four "boundary" values around the partition.
            // Aleft  = last element included from A's left part (or -infinity if i = 0)
            // Aright = first element in A's right part (or +infinity if i = m, meaning nothing left)
            // Bleft  = last element included from B's left part (or -infinity if j = 0)
            // Bright = first element in B's right part (or +infinity if j = n, meaning nothing left)
            int Aleft  = (i > 0) ? A[i - 1] : Integer.MIN_VALUE;
            int Aright = (i < m) ? A[i]     : Integer.MAX_VALUE;
            int Bleft  = (j > 0) ? B[j - 1] : Integer.MIN_VALUE;
            int Bright = (j < n) ? B[j]     : Integer.MAX_VALUE;

            // Step 4: Check if this is the CORRECT partition.
            // A valid partition means everything on the left side (from both arrays)
            // is smaller than or equal to everything on the right side (from both arrays).
            if (Aleft <= Bright && Bleft <= Aright) {
                // Found it! The k-th smallest element is the LARGER of the two
                // "last elements" in the left parts (since left parts together hold k elements,
                // the biggest one among them is exactly the k-th smallest overall).
                return Math.max(Aleft, Bleft);
            }
            // Step 5: If Aleft is too big (bigger than Bright), we took too many from A.
            // Shift the search to take fewer elements from A.
            else if (Aleft > Bright) {
                high = i - 1;
            }
            // Step 6: Otherwise, we took too few elements from A. Take more from A.
            else {
                low = i + 1;
            }
        }

        // This should never be reached if inputs are valid (k within range 1..m+n)
        throw new IllegalArgumentException("Invalid input: k is out of valid range");
    }

    // Main method: takes user input and prints the result
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Step 1: Read array A
        System.out.println("Enter the number of elements in array A:");
        int m = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Enter " + m + " sorted integers for A, separated by spaces:");
        String[] partsA = scanner.nextLine().trim().split("\\s+");
        int[] A = new int[m];
        for (int i = 0; i < m; i++) {
            A[i] = Integer.parseInt(partsA[i]);
        }

        // Step 2: Read array B
        System.out.println("Enter the number of elements in array B:");
        int n = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Enter " + n + " sorted integers for B, separated by spaces:");
        String[] partsB = scanner.nextLine().trim().split("\\s+");
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            B[i] = Integer.parseInt(partsB[i]);
        }

        // Step 3: Read k
        System.out.println("Enter k (which smallest element you want, 1-indexed):");
        int k = Integer.parseInt(scanner.nextLine().trim());

        // Step 4: Call the function and print the result
        int result = findKthSmallest(A, B, k);

        System.out.println("The " + k + "-th smallest element is: " + result);

        scanner.close();
    }
}