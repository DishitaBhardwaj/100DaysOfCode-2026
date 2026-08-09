
class Solution {
    public int kthElement(int[] a, int[] b, int k) {
        int n = a.length;
        int m = b.length;
        if (n > m) {
            return kthElement(b, a, k);
        }

        int l = Math.max(0, k - m);
        int h = Math.min(k, n);

        while (l <= h) {
            int c1 = (l + h) / 2;
            int c2 = k - c1;

            int l1 = (c1 == 0) ? Integer.MIN_VALUE : a[c1 - 1];
            int l2 = (c2 == 0) ? Integer.MIN_VALUE : b[c2 - 1];

            int r1 = (c1 == n) ? Integer.MAX_VALUE : a[c1];
            int r2 = (c2 == m) ? Integer.MAX_VALUE : b[c2];

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                h = c1 - 1;
            } else {
                l = c1 + 1;
            }
        }

        return -1;
    }
}