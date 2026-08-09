import java.util.*;

public class Question_2 {

    public static int kthSmallest(int[] A, int[] B, int k) {
        int i = 0, j = 0;

        while (true) {
            if (i == A.length)
                return B[j + k - 1];

            if (j == B.length)
                return A[i + k - 1];

            if (k == 1)
                return Math.min(A[i], B[j]);

            int half = k / 2;

            int newI = Math.min(i + half, A.length) - 1;
            int newJ = Math.min(j + half, B.length) - 1;

            if (A[newI] <= B[newJ]) {
                k -= (newI - i + 1);
                i = newI + 1;
            } else {
                k -= (newJ - j + 1);
                j = newJ + 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of first array: ");
        int n = sc.nextInt();

        int[] A = new int[n];

        System.out.println("Enter elements of first sorted array:");
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        System.out.print("Enter size of second array: ");
        int m = sc.nextInt();

        int[] B = new int[m];

        System.out.println("Enter elements of second sorted array:");
        for (int i = 0; i < m; i++) {
            B[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        System.out.println("K-th Smallest Element: " + kthSmallest(A, B, k));

        sc.close();
    }
}