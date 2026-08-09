import java.util.Arrays;
import java.util.Scanner;

public class Question2 {
    public static int[] assemblyViaMinimums(int n, int[] arr) {
        Arrays.sort(arr);

        int[] ans = new int[n];
        int id = 0;
        int step = n - 1;
        for (int i = 0; i < n - 1; i++) {
            ans[i] = arr[id];
            id += step;
            step--;
        }
        ans[n - 1] = ans[n - 2];
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the original array (n): ");
        int n = sc.nextInt();

        int sizeB = n * (n - 1) / 2;
        int[] b = new int[sizeB];

        System.out.println("Enter " + sizeB + " elements of array b: ");

        for (int i = 0; i < sizeB; i++) {
            b[i] = sc.nextInt();
        }

        int[] a = assemblyViaMinimums(n, b);

        System.out.println("The output array a: " + Arrays.toString(a));

        sc.close();
    }
}