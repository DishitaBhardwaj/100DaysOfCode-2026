import java.util.PriorityQueue;

public class Question1_LeetCode {
    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(new int[]{nums[i], i});
        }
        
        for (int i = 0; i < k; i++) {
            int[] min = minHeap.poll();
            min[0] *= multiplier;

            minHeap.offer(min);
        }
        
        while (!minHeap.isEmpty()) {
            int[] a = minHeap.poll();
            nums[a[1]] = a[0];
        }
        return nums;
    }
}
