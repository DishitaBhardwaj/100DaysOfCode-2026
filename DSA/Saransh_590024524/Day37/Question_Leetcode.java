package DSA.Saransh_590024524.Day37;

import java.util.*;

class RecentCounter {

    Queue<Integer> q;

    public RecentCounter() {
        q = new LinkedList<>();
    }
    public int ping(int t) {
        q.add(t);
        while (q.peek() < t - 3000) {
            q.remove();
        }
        return q.size();
    }
}