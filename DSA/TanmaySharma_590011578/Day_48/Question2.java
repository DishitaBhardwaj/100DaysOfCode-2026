package DSA.TanmaySharma_590011578.Day_48;

import java.util.Arrays;
import java.util.Scanner;

public class Question2 {
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

        for (int i = 0; i < n - 1; i++) {
            a[i] = b[index];
            index += (n - i - 1);
        }

        a[n - 1] = 1000000000;

        for (int i = 0; i < n; i++) {
            System.out.print(a[i]);
            if (i != n - 1) {
                System.out.print(" ");
            }
        }

        sc.close();
    }
}