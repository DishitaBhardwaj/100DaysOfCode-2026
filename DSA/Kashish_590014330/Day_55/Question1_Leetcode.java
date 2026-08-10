import java.util.*;

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {

        int n = nums.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(b[0], a[0]));
        int[][] selected = new int[k][2];

        for (int i = 0; i < k; i++) {
            selected[i] = arr[i];
        }
        Arrays.sort(selected, (a, b) -> Integer.compare(a[1], b[1]));

        int[] answer = new int[k];

        for (int i = 0; i < k; i++) {
            answer[i] = selected[i][0];
        }

        return answer;
    }
}