import java.util.*;

public class Question2 {

    public static int kthElement(int[] A, int[] B, int k) {
        int n = A.length;
        int m = B.length;

        if (n > m) {
            return kthElement(B, A, k);
        }

        int low = Math.max(0, k - m);
        int high = Math.min(k, n);

        while (low <= high) {
            int cut1 = (low + high) / 2;
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
        int[] A = {2, 3, 6, 7};
        int[] B = {1, 4, 5, 8};
        int k = 5;

        System.out.println(kthElement(A, B, k)); 
    }
}