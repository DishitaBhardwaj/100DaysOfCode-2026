public class Question2 {
    public int f(int[] a) {
        int x = a[0], y = a[0];
        for (int v : a) {
            x = Math.min(x, v);
            y = Math.max(y, v);
        }
        return (a.length - 1) * (y - x);
    }
}