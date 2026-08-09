import java.util.Scanner;

public class Question2 {
    public static int findKthSmallest(int[] A, int[] B, int k) {
        int n = A.length;
        int m = B.length;

        if (n > m) {
            return findKthSmallest(B, A, k);
        }

        int low = Math.max(0, k - m);
        int high = Math.min(k, n);

        while (low <= high) {
            int cut1 = low + (high - low) / 2;
            int cut2 = k - cut1;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : A[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : B[cut2 - 1];
            int r1 = (cut1 == n) ? Integer.MAX_VALUE : A[cut1];
            int r2 = (cut2 == m) ? Integer.MAX_VALUE : B[cut2];

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } 
            else if (l1 > r2) {
                high = cut1 - 1;
            } 
            else {
                low = cut1 + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the size of array A: ");
        int n = sc.nextInt();
        int[] A = new int[n];
        System.out.println("Enter the " + n + " elements of array A (sorted in ascending order):");
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        System.out.print("Enter the size of array B: ");
        int m = sc.nextInt();
        int[] B = new int[m];
        System.out.println("Enter the " + m + " elements of array B (sorted in ascending order):");
        for (int i = 0; i < m; i++) {
            B[i] = sc.nextInt();
        }

        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();

            
        int result = findKthSmallest(A, B, k);
        System.out.println("\nThe " + k + "-th smallest element is: " + result);
        sc.close();
    }
}