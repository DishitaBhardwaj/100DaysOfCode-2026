import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int time(int[] tickets, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < tickets.length; i++) {
            queue.add(i);
        }
        int time = 0;
        while (!queue.isEmpty()) {
            int person = queue.remove();
            tickets[person]--;
            time++;
            if (person == k && tickets[person] == 0) {
                return time;
            }
            if (tickets[person] > 0) {
                queue.add(person);
            }
        }
        return time;
    }
}