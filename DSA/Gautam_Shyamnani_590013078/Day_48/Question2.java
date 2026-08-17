import java.util.*;

public class Question2 {

    public static int[] reconstruct(int n, int[] b) {
        Arrays.sort(b);

        int[] a = new int[n];
        int idx = 0;

        for (int i = 0; i < n - 1; i++) {
            a[i] = b[idx];
            idx += (n - i - 1);
        }

        a[n - 1] = (int) 1e9;

        return a;
    }

    public static void main(String[] args) {

        int n = 3;
        int[] b = {4, 2, 2};

        int[] result = reconstruct(n, b);

        System.out.println("Reconstructed array:");
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}