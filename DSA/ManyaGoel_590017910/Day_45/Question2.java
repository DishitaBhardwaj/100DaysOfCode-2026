import java.util.*;
public class Question2 {
    public static long countInversions(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int[] buffer = new int[nums.length];
        return sortAndCount(nums, buffer, 0, nums.length - 1);
    }
    private static long sortAndCount(int[] nums, int[] buffer, int low, int high) {
        long count = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;

            count += sortAndCount(nums, buffer, low, mid);
            count += sortAndCount(nums, buffer, mid + 1, high);
            count += mergeAndCount(nums, buffer, low, mid, high);
        }
        return count;
    }
    private static long mergeAndCount(int[] nums, int[] buffer, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int pos = low;
        long count = 0;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                buffer[pos++] = nums[left++];
            } else {
                buffer[pos++] = nums[right++];
                count += (mid - left + 1);
            }
        }
        while (left <= mid) {
            buffer[pos++] = nums[left++];
        }
        while (right <= high) {
            buffer[pos++] = nums[right++];
        }
        for (int x = low; x <= high; x++) {
            nums[x] = buffer[x];
        }

        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println("Array :" + Arrays.toString(nums));

        long totalInversions = countInversions(nums);
        System.out.println("Total inversions: " + totalInversions);
        sc.close();
    }
}