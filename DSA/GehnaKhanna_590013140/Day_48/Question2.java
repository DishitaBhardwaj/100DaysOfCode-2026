import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int m = n * (n - 1) / 2;
        int[] b = new int[m];

        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        Arrays.sort(b);

        int[] a = new int[n];

        int idx = 0;
        for (int i = 0; i < n - 1; i++) {
            a[i] = b[idx];
            idx += (n - i - 1);
        }

        a[n - 1] = 1000000000;

        for (int x : a) {
            System.out.print(x + " ");
        }

        sc.close();
    }
}
