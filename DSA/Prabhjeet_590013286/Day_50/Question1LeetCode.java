/**
 * LeetCode 3264 - Final Array State After K Multiplication Operations I
 */

//Need to multiply the smallest element k times

class Solution {

    public int[] getFinalState(int[] nums, int k, int multiplier) {

        while (k-- > 0) {

            int minIndex = 0;

            // pick the first occurrence of the smallest value
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[minIndex]) {
                    minIndex = i;
                }
            }

            nums[minIndex] *= multiplier;
        }

        return nums;
    }
}