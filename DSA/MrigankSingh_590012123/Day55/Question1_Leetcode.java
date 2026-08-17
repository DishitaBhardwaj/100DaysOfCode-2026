package Day55;
import java.util.Arrays;

public class Question1_Leetcode {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[][] pairs = new int[n][2];

        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }

        Arrays.sort(pairs, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(b[0], a[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int[][] selected = new int[k][2];
        for (int i = 0; i < k; i++) {
            selected[i] = pairs[i];
        }

        Arrays.sort(selected, (a, b) -> Integer.compare(a[1], b[1]));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = selected[i][0];
        }

        return result;
    }
}