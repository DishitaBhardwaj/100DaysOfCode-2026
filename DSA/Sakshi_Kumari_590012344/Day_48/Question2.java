import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int size = n * (n - 1) / 2;
            int[] b = new int[size];

            for (int i = 0; i < size; i++) {
                b[i] = sc.nextInt();
            }

            Arrays.sort(b);

            int[] a = new int[n];
            int index = 0;

            for (int i = 0; i < n - 1; i++) {
                a[i] = b[index];
                index += (n - 1 - i);
            }

            a[n - 1] = 1000000000;

            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
