import java.util.*;

public class Question1_Leetcode {

    public static int[] getFinalState(int[] nums, int k, int multiplier) {

        while (k-- > 0) {

            int minIndex = 0;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[minIndex]) {
                    minIndex = i;
                }
            }

            nums[minIndex] *= multiplier;
        }

        return nums;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        int multiplier = sc.nextInt();

        int[] ans = getFinalState(nums, k, multiplier);

        System.out.print("[");

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]);

            if (i != ans.length - 1) {
                System.out.print(",");
            }
        }

        System.out.println("]");

        sc.close();
    }
}