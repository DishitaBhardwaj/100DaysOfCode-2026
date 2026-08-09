import java.util.Arrays;

public class Main {

    public static int maximumPrefixDifferenceScore(int[] nums) {

        Arrays.sort(nums);

        int minPrefix = nums[0];
        int maxPrefix = nums[0];
        int score = 0;

        for (int i = 0; i < nums.length; i++) {
            maxPrefix = Math.max(maxPrefix, nums[i]);
            score += (maxPrefix - minPrefix);
        }

        return score;
    }

    public static void main(String[] args) {

        int[] nums1 = {5};
        System.out.println(maximumPrefixDifferenceScore(nums1));

        int[] nums2 = {7, 6, 5};
        System.out.println(maximumPrefixDifferenceScore(nums2));

        int[] nums3 = {1, 1, 1, 2, 2};
        System.out.println(maximumPrefixDifferenceScore(nums3));
    }
}