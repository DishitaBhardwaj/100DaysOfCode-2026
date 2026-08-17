import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int f = sc.nextInt() - 1;
            int k = sc.nextInt();

            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            int fav = nums[f];

            int greater = 0, greaterOrEqual = 0;

            for (int x : nums) {
                if (x > fav) greater++;
                if (x >= fav) greaterOrEqual++;
            }

            if (greater >= k) {
                System.out.println("NO");
            } else if (greaterOrEqual <= k) {
                System.out.println("YES");
            } else {
                System.out.println("MAYBE");
            }
        }
    }
}