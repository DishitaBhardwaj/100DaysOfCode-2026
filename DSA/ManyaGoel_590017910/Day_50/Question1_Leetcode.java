class Question1_Leetcode {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(new int[]{nums[i], i});
        }
        while (k > 0) {
            int[] smallest = minHeap.poll();
            int value = smallest[0];
            int index = smallest[1];
            nums[index] = value * multiplier;
            minHeap.offer(new int[]{nums[index], index});
            k--;
        }
        return nums;
    }
}