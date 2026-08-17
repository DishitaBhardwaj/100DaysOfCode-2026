package DSA.TanmaySharma_590011578.Day_50;
import java.util.PriorityQueue;

class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        while (k-- > 0) {
            int[] cur = pq.poll();
            int value = cur[0];
            int index = cur[1];

            value *= multiplier;
            nums[index] = value;

            pq.offer(new int[]{value, index});
        }

        return nums;
    }
}