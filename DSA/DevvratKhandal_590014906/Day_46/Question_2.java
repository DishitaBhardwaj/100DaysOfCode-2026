import java.util.*;

public class Question_2 {

    public static int maximumScore(int[] nums) {

        Arrays.sort(nums);

        int min = nums[0];
        int max = nums[0];
        int score = 0;

        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            score += (max - min);
        }

        return score;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int score = maximumScore(nums);

        System.out.println("Maximum Prefix Difference Score: " + score);

        sc.close();
    }
}