import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();

            int size = n * (n - 1) / 2;

            long[] b = new long[size];

            for (int i = 0; i < size; i++) {
                b[i] = sc.nextLong();
            }

            Arrays.sort(b);

            ArrayList<Long> ans = new ArrayList<>();

            int idx = 0;

            for (int i = 0; i < n - 1; i++) {
                ans.add(b[idx]);
                idx += (n - i - 1);
            }

            ans.add((long)1e9);

            for (long x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
