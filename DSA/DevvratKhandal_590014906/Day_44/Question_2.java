import java.util.*;

class Question_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter favorite index: ");
        int favoriteIndex = sc.nextInt();

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int favorite = nums[favoriteIndex - 1];

        int greater = 0;
        int equal = 0;

        for (int num : nums) {
            if (num > favorite) {
                greater++;
            } else if (num == favorite) {
                equal++;
            }
        }

        if (greater >= k) {
            System.out.println("Output: NO");
        } else if (greater + equal <= k) {
            System.out.println("Output: YES");
        } else {
            System.out.println("Output: MAYBE");
        }

        sc.close();
    }
}