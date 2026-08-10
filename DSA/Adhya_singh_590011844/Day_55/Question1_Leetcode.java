import java.util.*;

public class Main {

    public static int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;

        Integer[] indices = new Integer[n];

        // Store original indices
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort by value in descending order
        Arrays.sort(indices, (a, b) -> {
            return Integer.compare(nums[b], nums[a]);
        });

        // Take k largest elements
        Integer[] selected = Arrays.copyOf(indices, k);

        // Sort selected indices to preserve original order
        Arrays.sort(selected);

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = nums[selected[i]];
        }

        return result;
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

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int[] result = maxSubsequence(nums, k);

        System.out.println("Maximum sum subsequence:");

        for (int value : result) {
            System.out.print(value + " ");
        }

        System.out.println();

        sc.close();
    }
}