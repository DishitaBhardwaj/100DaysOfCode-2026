import java.util.*;

public class Question1_Leetcode {

    public static int[] maxSubsequence(int[] nums, int k) {

        int n = nums.length;

        // Store value and original index
        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort indices according to values in descending order
        Arrays.sort(indices, (a, b) -> Integer.compare(nums[b], nums[a]));

        // Mark selected elements
        boolean[] selected = new boolean[n];

        for (int i = 0; i < k; i++) {
            selected[indices[i]] = true;
        }

        // Build result in original order
        int[] result = new int[k];
        int index = 0;

        for (int i = 0; i < n; i++) {
            if (selected[i]) {
                result[index++] = nums[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        int[] result = maxSubsequence(nums, k);

        System.out.print("[");

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");

        sc.close();
    }
}