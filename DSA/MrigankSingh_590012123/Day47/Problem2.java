public class Problem2 {
    public int kthSmallestInTwoSortedArrays(int[] a, int[] b, int k) {
        if (a.length > b.length) {
            return kthSmallestInTwoSortedArrays(b, a, k);
        }

        int m = a.length;
        int n = b.length;
        int low = Math.max(0, k - n);
        int high = Math.min(k, m);

        while (low <= high) {
            int cutA = low + (high - low) / 2;
            int cutB = k - cutA;

            int leftA = cutA == 0 ? Integer.MIN_VALUE : a[cutA - 1];
            int rightA = cutA == m ? Integer.MAX_VALUE : a[cutA];
            int leftB = cutB == 0 ? Integer.MIN_VALUE : b[cutB - 1];
            int rightB = cutB == n ? Integer.MAX_VALUE : b[cutB];

            if (leftA <= rightB && leftB <= rightA) {
                return Math.max(leftA, leftB);
            }

            if (leftA > rightB) {
                high = cutA - 1;
            } else {
                low = cutA + 1;
            }
        }

        return -1;
    }
}