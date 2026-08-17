import java.util.Scanner;

public class Main {

    public static String favoriteNumber(int[] nums, int favoriteIndex, int k) {
        int favorite = nums[favoriteIndex - 1]; // 1-based index

        int greater = 0;
        int equal = 0;

        // Count numbers greater than and equal to favorite number
        for (int num : nums) {
            if (num > favorite) {
                greater++;
            } else if (num == favorite) {
                equal++;
            }
        }

        if (k <= greater) {
            return "NO";
        } else if (k >= greater + equal) {
            return "YES";
        } else {
            return "MAYBE";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int favoriteIndex = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(favoriteNumber(nums, favoriteIndex, k));

        sc.close();
    }
}