class Solution {
    public int[] maxSlidingWindow(int[] temperatures, int k) {

        int n = temperatures.length;
        int[] ans = new int[n - k + 1];

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {


            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }


            while (!deque.isEmpty() &&
                   temperatures[deque.peekLast()] <= temperatures[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                ans[i - k + 1] = temperatures[deque.peekFirst()];
            }
        }

        return ans;
    }
}