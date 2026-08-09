import java.util.*;
public class Question2 {
    public static int findKthSmallest(int[] A, int[] B, int k) {
       if (A.length > B.length) return findKthSmallest(B, A, k); 

        int n = A.length, m = B.length;
        int low = Math.max(0, k - m);
        int high = Math.min(k, n);

        while (low <= high) {
            int i = low + (high - low) / 2;
            int j = k - i;

            int Aleft  = (i == 0) ? Integer.MIN_VALUE : A[i - 1];
            int Aright = (i == n) ? Integer.MAX_VALUE : A[i];
            int Bleft  = (j == 0) ? Integer.MIN_VALUE : B[j - 1];
            int Bright = (j == m) ? Integer.MAX_VALUE : B[j];

            if (Aleft <= Bright && Bleft <= Aright) {
                return Math.max(Aleft, Bleft);
            } else if (Aleft > Bright) {
                high = i - 1;
            } else {
                low = i + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array A: ");
        int n = sc.nextInt();
        int[] A = new int[n];
        System.out.println("Enter elements of array A (sorted ascending):");
        for (int i = 0; i < n; i++) A[i] = sc.nextInt();
        System.out.print("Enter size of array B: ");
        int m = sc.nextInt();
        int[] B = new int[m];
        System.out.println("Enter elements of array B (sorted ascending):");
        for (int i = 0; i < m; i++) B[i] = sc.nextInt();

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int result = findKthSmallest(A, B, k);
        System.out.println("The " + k + "-th smallest element is: " + result);

        sc.close();
    }
}