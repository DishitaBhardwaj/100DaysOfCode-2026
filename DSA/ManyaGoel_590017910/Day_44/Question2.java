import java.util.Scanner;
public class Question2 {
    public static String favouriteNumber(int[] nums, int favoriteIndex, int k) {
        int val = nums[favoriteIndex - 1];
        int greater = 0, equal = 0;

        for (int num : nums) {
            if (num > val) greater++;
            else if (num == val) equal++;
        }

        if (k >= greater + equal) return "YES";
        if (k <= greater) return "NO";
        return "MAYBE";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter " + n + " elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter favoriteIndex (1-indexed): ");
        int favoriteIndex = sc.nextInt();

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        System.out.println("Output: " + favouriteNumber(nums, favoriteIndex, k));
        sc.close();
    }
}