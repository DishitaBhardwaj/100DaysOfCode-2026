public class Kth_Smallest {
    

    public static int kthSmallest(int[] A, int[] B, int k) {

        // Always perform binary search on the smaller array
        if (A.length > B.length) {
            return kthSmallest(B, A, k);
        }

        int n = A.length;
        int m = B.length;

        int low = Math.max(0, k - m);
        int high = Math.min(k, n);

        while (low <= high) {

            // Number of elements taken from A
            int cutA = (low + high) / 2;

            // Remaining elements taken from B
            int cutB = k - cutA;

            // Left and Right values around the partition
            int leftA = (cutA == 0) ? Integer.MIN_VALUE : A[cutA - 1];
            int rightA = (cutA == n) ? Integer.MAX_VALUE : A[cutA];

            int leftB = (cutB == 0) ? Integer.MIN_VALUE : B[cutB - 1];
            int rightB = (cutB == m) ? Integer.MAX_VALUE : B[cutB];

            // Correct partition found
            if (leftA <= rightB && leftB <= rightA) {
                return Math.max(leftA, leftB);
            }

            // Too many elements taken from A
            else if (leftA > rightB) {
                high = cutA - 1;
            }

            // Too few elements taken from A
            else {
                low = cutA + 1;
            }
        }

        return -1; // Invalid k
    }

    public static void main(String[] args) {

        int[] A = {2, 3, 6, 7};
        int[] B = {1, 4, 5, 8};

        int k = 5;

        System.out.println("K-th Smallest Element = " + kthSmallest(A, B, k));
    }
}
