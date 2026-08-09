import java.util.*;

public class Question_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int size = n * (n - 1) / 2;
        int[] b = new int[size];

        System.out.println("Enter elements of b:");
        for (int i = 0; i < size; i++) {
            b[i] = sc.nextInt();
        }

        Arrays.sort(b);

        int[] ans = new int[n];
        int idx = 0;

        for (int i = 0; i < n - 1; i++) {
            ans[i] = b[idx];
            idx += (n - 1 - i);
        }

        ans[n - 1] = 1000000000;

        System.out.print("Constructed Array: [");
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i]);
            if (i != n - 1)
                System.out.print(", ");
        }
        System.out.println("]");

        sc.close();
    }
}