import java.util.*;

public class Question2 {

    public static int maximumPrefixDifferenceScore(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return 0;
        }

        Arrays.sort(nums);

        int min = nums[0];
        int max = nums[n - 1];

        return (n - 1) * (max - min);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(maximumPrefixDifferenceScore(nums));

        sc.close();
    }
}