public class Main {

    static int kthSmallest(int[] A, int[] B, int k) {
        if (A.length > B.length)
            return kthSmallest(B, A, k);

        int m = A.length;
        int n = B.length;

        int low = Math.max(0, k - n);
        int high = Math.min(k, m);

        while (low <= high) {
            int cutA = low + (high - low) / 2;
            int cutB = k - cutA;

            int leftA = cutA == 0 ? Integer.MIN_VALUE : A[cutA - 1];
            int leftB = cutB == 0 ? Integer.MIN_VALUE : B[cutB - 1];

            int rightA = cutA == m ? Integer.MAX_VALUE : A[cutA];
            int rightB = cutB == n ? Integer.MAX_VALUE : B[cutB];

            if (leftA <= rightB && leftB <= rightA)
                return Math.max(leftA, leftB);

            if (leftA > rightB)
                high = cutA - 1;
            else
                low = cutA + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] A = {2, 3, 6, 7};
        int[] B = {1, 4, 5, 8};

        System.out.println(kthSmallest(A, B, 5));
    }
}