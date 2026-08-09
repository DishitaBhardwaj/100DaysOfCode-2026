package DSA.TanmaySharma_590011578.Day_44;

import java.util.*;

public class Question2 {

    static String favoriteNumber(int[] nums, int favoriteIndex, int k) {
        int favorite = nums[favoriteIndex - 1];

        Arrays.sort(nums);

        int count = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] >= favorite) {
                count++;
            }
        }

        if (count <= k) {
            return "NO";
        }

        return "YES";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Enter favorite index:");
        int favoriteIndex = sc.nextInt();

        System.out.println("Enter k:");
        int k = sc.nextInt();

        String result = favoriteNumber(nums, favoriteIndex, k);

        System.out.println("Result: " + result);

        sc.close();
    }
}