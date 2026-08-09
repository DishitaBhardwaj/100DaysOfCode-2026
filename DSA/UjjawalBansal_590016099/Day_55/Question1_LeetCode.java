import java.util.Arrays;
import java.util.PriorityQueue;

public class Question1_LeetCode {
    public static int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(new int[]{nums[i], i});

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        int[][] top = new int[k][2];
        for (int i = 0; i < k; i++) {
            top[i] = minHeap.poll();
        }
        
        Arrays.sort(top, (a, b) -> a[1] - b[1]);
        
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = top[i][0];
        }
        return result;
    }
}
