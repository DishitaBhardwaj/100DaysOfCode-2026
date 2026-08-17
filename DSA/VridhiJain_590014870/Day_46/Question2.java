import java.util.Arrays;
class Solution {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        int max = nums[0];
        int min = nums[0];
        int score = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
            score += (max - min);
        }
        return score;
    }
}