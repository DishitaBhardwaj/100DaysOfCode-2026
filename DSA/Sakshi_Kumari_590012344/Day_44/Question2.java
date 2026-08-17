import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int f = sc.nextInt();
            int k = sc.nextInt();

            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            int fav = nums[f - 1];

            int greater = 0;
            int equal = 0;

            for (int x : nums) {
                if (x > fav) {
                    greater++;
                } else if (x == fav) {
                    equal++;
                }
            }

            if (k <= greater) {
                System.out.println("NO");
            } else if (k >= greater + equal) {
                System.out.println("YES");
            } else {
                System.out.println("MAYBE");
            }
        }

        sc.close();
    }
}
