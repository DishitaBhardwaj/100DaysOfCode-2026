public class Question2 {
    public static int kthSmallest(int[] a, int[] b, int k) {
        
        if (a.length > b.length) return kthSmallest(b, a, k);
        int n = a.length, m = b.length;
        int l = Math.max(0, k - m), r = Math.min(k, n);

        while (l <= r) {
            int x = (l + r) >> 1;
            int y = k - x;
            int al = x == 0 ? Integer.MIN_VALUE : a[x - 1];
            int ar = x == n ? Integer.MAX_VALUE : a[x];
            int bl = y == 0 ? Integer.MIN_VALUE : b[y - 1];
            int br = y == m ? Integer.MAX_VALUE : b[y];

            if (al <= br && bl <= ar) return Math.max(al, bl);
            if (al > br) r = x - 1;
            else l = x + 1;
        } return -1;
    }
}