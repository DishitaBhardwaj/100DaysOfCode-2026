class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        );

        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        while (k-- > 0) {
            int[] curr = pq.poll();
            int value = curr[0];
            int index = curr[1];

            value *= multiplier;
            nums[index] = value;

            pq.offer(new int[]{value, index});
        }

        return nums;
        
    }
}
