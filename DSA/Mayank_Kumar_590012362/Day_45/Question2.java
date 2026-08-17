public class Question2 {
    static long f(int[] a) {
        return g(a, 0, a.length - 1, new int[a.length]);
    }

    static long g(int[] a, int l, int r, int[] t) {
        if (l >= r) return 0;
        int m = (l + r) >> 1, i = l, j = m + 1, k = l;
        long c = g(a, l, m, t) + g(a, m + 1, r, t);
        while (i <= m && j <= r)
            if (a[i] <= a[j]) t[k++] = a[i++];
            else {
                t[k++] = a[j++];
                c += m - i + 1;
            }
        while (i <= m) t[k++] = a[i++];
        while (j <= r) t[k++] = a[j++];
        for (i = l; i <= r; i++) a[i] = t[i];
        return c;
    }
}