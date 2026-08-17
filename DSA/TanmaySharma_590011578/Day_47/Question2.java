package DSA.TanmaySharma_590011578.Day_47;

import java.util.*;

public class Question2 {

    static int kthSmallest(int[] A, int[] B, int k) {
        if (A.length > B.length) {
            return kthSmallest(B, A, k);
        }

        int m = A.length;
        int n = B.length;

        int low = Math.max(0, k - n);
        int high = Math.min(k, m);

        while (low <= high) {
            int i = (low + high) / 2;
            int j = k - i;

            int Aleft = (i == 0) ? Integer.MIN_VALUE : A[i - 1];
            int Aright = (i == m) ? Integer.MAX_VALUE : A[i];

            int Bleft = (j == 0) ? Integer.MIN_VALUE : B[j - 1];
            int Bright = (j == n) ? Integer.MAX_VALUE : B[j];

            if (Aleft <= Bright && Bleft <= Aright) {
                return Math.max(Aleft, Bleft);
            }

            if (Aleft > Bright) {
                high = i - 1;
            } else {
                low = i + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of first array: ");
        int m = sc.nextInt();

        int[] A = new int[m];

        System.out.println("Enter elements of first sorted array:");
        for (int i = 0; i < m; i++) {
            A[i] = sc.nextInt();
        }

        System.out.print("Enter size of second array: ");
        int n = sc.nextInt();

        int[] B = new int[n];

        System.out.println("Enter elements of second sorted array:");
        for (int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        if (k < 1 || k > m + n) {
            System.out.println("Invalid value of k");
        } else {
            int result = kthSmallest(A, B, k);
            System.out.println("The " + k + "-th smallest element is: " + result);
        }

        sc.close();
    }
}