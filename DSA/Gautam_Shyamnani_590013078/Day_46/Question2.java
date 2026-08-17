import java.util.*;

public class Question2 {

    public static int maxScore(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        Arrays.sort(nums);

        int minVal = nums[0];
        int maxVal = nums[n - 1];

        return (n - 1) * (maxVal - minVal);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2};
        System.out.println(maxScore(nums)); 
    }
}