package DSA.Mugdha_590015431.Day_44;
import java.util.Scanner;

public class Question2 {

    public static String favouriteNumber(int[] nums, int favoriteIndex, int k) {
        int fav = nums[favoriteIndex - 1];

        int greater = 0;
        int equal = 0;

        for (int num : nums) {
            if (num > fav) {
                greater++;
            } else if (num == fav) {
                equal++;
            }
        }

        if (greater >= k) {
            return "YES";
        } else if (greater + equal <= k) {
            return "NO";
        } else {
            return "MAYBE";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of elements
        int n = sc.nextInt();

        // Input array
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Input favorite index (1-based)
        int favoriteIndex = sc.nextInt();

        // Input k
        int k = sc.nextInt();

        System.out.println(favouriteNumber(nums, favoriteIndex, k));

        sc.close();
    }
}