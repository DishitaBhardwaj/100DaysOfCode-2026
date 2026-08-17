import java.util.*;
public class Main {
    public static String favoriteNumber(int[] nums, int favoriteIndex, int k) {
        int favorite = nums[favoriteIndex - 1];
        int greater = 0;
        int equal = 0;
        for (int num : nums) {
            if (num > favorite)
                greater++;
            else if (num == favorite)
                equal++;
        }
        if (greater >= k)
            return "NO";
        if (greater + equal <= k)
            return "YES";
        return "MAYBE";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter favorite index (1-based): ");
        int favoriteIndex = sc.nextInt();

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        System.out.println(favoriteNumber(nums, favoriteIndex, k));

        sc.close();
    }
}
