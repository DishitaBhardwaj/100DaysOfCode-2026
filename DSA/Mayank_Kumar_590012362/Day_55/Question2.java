import java.util.Arrays;
import java.util.PriorityQueue;
public class Question2 {
    public static long maxPleasure(int[] a, int[] b, int k) {
        Integer[] c = new Integer[a.length];
        for (int i = 0; i < a.length; i++) c[i] = i;
        Arrays.sort(c, (i, j) -> b[j] - b[i]);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        long s = 0, r = 0;
        for (int i : c) {
            q.add(a[i]);
            s += a[i];
            if (q.size() > k) s -= q.poll();
            if (q.size() == k) r = Math.max(r, s * b[i]);
        } return r;
    }
}