import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int f = sc.nextInt();
            int k = sc.nextInt();

            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int fav = a[f - 1];

            int greater = 0;
            int equal = 0;

            for (int x : a) {
                if (x > fav)
                    greater++;
                else if (x == fav)
                    equal++;
            }

            if (greater >= k) {
                System.out.println("NO");
            } else if (greater + equal <= k) {
                System.out.println("YES");
            } else {
                System.out.println("MAYBE");
            }
        }

        sc.close();
    }
}