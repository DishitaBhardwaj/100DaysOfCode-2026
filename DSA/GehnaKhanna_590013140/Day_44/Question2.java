import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int favoriteIndex = sc.nextInt();
        int k = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int favorite = nums[favoriteIndex - 1];

        int greater = 0;
        int equal = 0;

        for (int num : nums) {
            if (num > favorite) {
                greater++;
            } else if (num == favorite) {
                equal++;
            }
        }

        if (greater >= k) {
            System.out.println("NO");
        } else if (greater + equal <= k) {
            System.out.println("YES");
        } else {
            System.out.println("MAYBE");
        }

        sc.close();
    }
}
