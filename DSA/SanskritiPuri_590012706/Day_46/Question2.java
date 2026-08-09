import java.util.Arrays;

public class Solution {

    public static int maximumPrefixDifferenceScore(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return 0;
        }

        Arrays.sort(nums);

        int min = nums[0];
        int max = nums[n - 1];

        return (n - 2) * (max - min);
    }

    public static void main(String[] args) {
        System.out.println(maximumPrefixDifferenceScore(new int[]{5}));             // 0
        System.out.println(maximumPrefixDifferenceScore(new int[]{7, 6, 5}));       // 4
        System.out.println(maximumPrefixDifferenceScore(new int[]{1, 1, 1, 2, 2})); // 4
    }
}
