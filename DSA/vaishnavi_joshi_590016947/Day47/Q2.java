import java.util.*;

class Solution {

    public static int kthElement(int[] A, int[] B, int k) {

        // Always perform binary search on the smaller array
        if (A.length > B.length) {
            return kthElement(B, A, k);
        }

        int n = A.length;
        int m = B.length;

        int low = Math.max(0, k - m);
        int high = Math.min(k, n);

        while (low <= high) {
            int cutA = (low + high) / 2;
            int cutB = k - cutA;

            int leftA = (cutA == 0) ? Integer.MIN_VALUE : A[cutA - 1];
            int leftB = (cutB == 0) ? Integer.MIN_VALUE : B[cutB - 1];

            int rightA = (cutA == n) ? Integer.MAX_VALUE : A[cutA];
            int rightB = (cutB == m) ? Integer.MAX_VALUE : B[cutB];

            if (leftA <= rightB && leftB <= rightA) {
                return Math.max(leftA, leftB);
            } else if (leftA > rightB) {
                high = cutA - 1;
            } else {
                low = cutA + 1;
            }
        }

        return -1; // Invalid k
    }

    public static void main(String[] args) {
        int[] A = {2, 3, 6, 7};
        int[] B = {1, 4, 5, 8};
        int k = 5;

        System.out.println(kthElement(A, B, k));
    }
}