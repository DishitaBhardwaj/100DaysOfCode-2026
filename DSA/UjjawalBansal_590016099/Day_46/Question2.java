import java.util.Scanner;

public class Question2 {
    public static int maximumPrefixDifferenceScore(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int max = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return (n - 1) * (max - min);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the " + n + " elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int maxScore = maximumPrefixDifferenceScore(nums);
        System.out.println("Maximum possible score: " + maxScore);
        sc.close();
    }
}