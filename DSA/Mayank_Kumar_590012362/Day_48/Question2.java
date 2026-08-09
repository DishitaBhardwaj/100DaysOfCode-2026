import java.util.Arrays;
public class Question2 {
    public static int[] assemblyViaMinimums(int n, int[] b) {
        Arrays.sort(b);
        int[] a = new int[n];
        int j = 0;
        for (int i = 0; i < n - 1; i++) {
            a[i] = b[j];
            j += n - i - 1;
        }
        a[n - 1] = 100;
        return a;
    }
}