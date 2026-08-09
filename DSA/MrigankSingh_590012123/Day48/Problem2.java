import java.util.Arrays;

public class Problem2 {
    public int[] assemblyViaMinimums(int n, int[] b) {
        Arrays.sort(b);
        int[] a = new int[n];

        int index = 0;
        for (int i = 0; i < n - 1; i++) {
            a[i] = b[index];
            index += (n - 1 - i);
        }

        a[n - 1] = 1000000000;
        return a;
    }
}