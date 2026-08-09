import java.util.*;

public class Main {

    public static int kthSmallest(int[] A, int[] B, int k) {

        // Always binary search on the smaller array
        if (A.length > B.length)
            return kthSmallest(B, A, k);

        int m = A.length;
        int n = B.length;

        int low = Math.max(0, k - n);
        int high = Math.min(k, m);

        while (low <= high) {

            int cutA = (low + high) / 2;
            int cutB = k - cutA;

            int leftA = (cutA == 0) ? Integer.MIN_VALUE : A[cutA - 1];
            int leftB = (cutB == 0) ? Integer.MIN_VALUE : B[cutB - 1];

            int rightA = (cutA == m) ? Integer.MAX_VALUE : A[cutA];
            int rightB = (cutB == n) ? Integer.MAX_VALUE : B[cutB];

            if (leftA <= rightB && leftB <= rightA) {
                return Math.max(leftA, leftB);
            } else if (leftA > rightB) {
                high = cutA - 1;
            } else {
                low = cutA + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int[] A = new int[m];

        for (int i = 0; i < m; i++)
            A[i] = sc.nextInt();

        int n = sc.nextInt();
        int[] B = new int[n];

        for (int i = 0; i < n; i++)
            B[i] = sc.nextInt();

        int k = sc.nextInt();

        System.out.println(kthSmallest(A, B, k));

        sc.close();
    }
}
