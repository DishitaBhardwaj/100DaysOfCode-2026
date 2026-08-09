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

        int index = 0;

        // Construct first n-1 elements
        for (int i = 0; i < n - 1; i++) {
            a[i] = b[index];
            index += (n - 1 - i);
        }

        // Last element can be any large value
        a[n - 1] = 1000000000;

        // Print answer
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]);
            if (i != n - 1)
                System.out.print(" ");
        }

        sc.close();
    }
}