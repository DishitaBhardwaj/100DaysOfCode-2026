import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements (must be even): ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        int sum = 0;

        for (int i = 0; i < n; i += 2) {
            sum += nums[i];
        }

        System.out.println("Maximum Sum of Pair Minimums = " + sum);

        sc.close();
    }
}
