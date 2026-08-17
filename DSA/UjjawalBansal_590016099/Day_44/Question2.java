import java.util.Scanner;

public class Question2 {

    public static String favouriteNumber(int[] nums, int favoriteIndex, int k) {
        int favNumber = nums[favoriteIndex - 1];
        int greater = 0;
        int equal = 0;
        
        for (int num : nums) {
            if (num > favNumber) {
                greater++;
            } else if (num == favNumber) {
                equal++;
            }
        }
        
        if (k >= greater + equal) return "YES"; 
        else if (k <= greater) return "NO";
        else return "MAYBE";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();

        System.out.println("Enter the index of favourite number(1-indexed): ");
        int favoriteIndex = sc.nextInt();

        System.out.println("Enter the removal count (k): ");
        int k = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the " + n + " elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        String fate = favouriteNumber(nums, favoriteIndex, k);
        System.out.println("Is the favorite element removed? " + fate);
        sc.close();
    }
}