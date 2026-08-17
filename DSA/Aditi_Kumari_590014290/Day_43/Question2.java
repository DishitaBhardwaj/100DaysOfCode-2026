/*Maximize Sum of Pair Minimums
Explanation
Write an efficient function to pair up 2n integers into n pairs such that the sum of the minimum values of each pair is maximized.

Example
Input: [1, 4, 3, 2]. Output: 4. */

import java.util.Arrays;

public class Question2 {
    public int arrayPairSum(int[] nums) {

        Arrays.sort(nums);

        int sum = 0;

        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }
}
