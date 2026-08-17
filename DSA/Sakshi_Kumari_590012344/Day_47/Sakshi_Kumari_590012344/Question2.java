class Solution {

    public int kthElement(int[] arr1, int[] arr2, int k) {

        if (arr1.length > arr2.length) {
            return kthElement(arr2, arr1, k);
        }

        int n = arr1.length;
        int m = arr2.length;

        int low = Math.max(0, k - m);
        int high = Math.min(k, n);

        while (low <= high) {

            int mid1 = (low + high) / 2;
            int mid2 = k - mid1;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if (mid1 < n) r1 = arr1[mid1];
            if (mid2 < m) r2 = arr2[mid2];

            if (mid1 > 0) l1 = arr1[mid1 - 1];
            if (mid2 > 0) l2 = arr2[mid2 - 1];

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }

            if (l1 > r2) {
                high = mid1 - 1;
            }

            else {
                low = mid1 + 1;
            }
        }

        return -1;
    }
}
