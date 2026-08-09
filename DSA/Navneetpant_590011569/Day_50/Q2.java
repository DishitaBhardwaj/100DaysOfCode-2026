class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int first = pq.poll();   // Heaviest
            int second = pq.poll();  // Second heaviest

            if (first != second) {
                pq.offer(first - second);
            }
        }
        if (pq.isEmpty()) {
            return 0;
        }
        else {
            return pq.poll();
        }
    }
}