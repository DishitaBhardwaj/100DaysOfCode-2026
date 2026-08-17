import java.util.*;

public class Question2 {

    public static int[] constructArray(int n, int[] b) {

        Arrays.sort(b);

        int[] a = new int[n];
        int index = 0;

        for (int i = 0; i < n - 1; i++) {
            a[i] = b[index];
            index += (n - i - 1);
        }

        a[n - 1] = 100;

        return a;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int size = n * (n - 1) / 2;
        int[] b = new int[size];

        for (int i = 0; i < size; i++) {
            b[i] = sc.nextInt();
        }

        int[] ans = constructArray(n, b);

        System.out.print("[");

        for (int i = 0; i < n; i++) {
            System.out.print(ans[i]);

            if (i != n - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");

        sc.close();
    }
}