public class Question2 {
    public String solve(int[] a, int f, int k) {
        int x = a[f - 1], g = 0, e = 0;
        for (int v : a) {
            if (v > x) g++;
            else if (v == x) e++;
        }
        return k <= g ? "NO" : k >= g + e ? "YES" : "MAYBE";
    }
}