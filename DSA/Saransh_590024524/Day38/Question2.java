import java.util.*;
class Solution {
    public int[] cardTrick(int n) {
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = n; i >= 1; i--) {
            if (!dq.isEmpty()) {
                dq.addFirst(dq.removeLast());
            }
            dq.addFirst(i);
        }
        int[] ans = new int[n];
        int index = 0;
        while (!dq.isEmpty()) {
            ans[index++] = dq.removeFirst();
        }
        return ans;
    }
}