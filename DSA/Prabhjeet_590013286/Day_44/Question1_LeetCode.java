/**
 * LeetCode 1502 - Can Make Arithmetic Progression From Sequence
 */

//Need to check if the numbers can form an arithmetic progression

import java.util.Arrays;

class Solution {

    public boolean canMakeArithmeticProgression(int[] arr) {

        Arrays.sort(arr);

        int diff = arr[1] - arr[0];

        // every pair should have the same difference
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }

        return true;
    }
}
