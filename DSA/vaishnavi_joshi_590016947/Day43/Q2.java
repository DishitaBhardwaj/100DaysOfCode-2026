import java.util.Arrays;

public class MaximizeSumOfPairMinimums {

    public static int arrayPairSum(int[] nums) {

        // Sort the array
        Arrays.sort(nums);

        int sum = 0;

        // Add every alternate element (minimum of each pair)
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }

    public static void main(String[] args) {

        int[] nums = {1, 4, 3, 2};

        int result = arrayPairSum(nums);

        System.out.println("Maximum Sum = " + result);
    }
}