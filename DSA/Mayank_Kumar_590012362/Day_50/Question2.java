public class Question2 {
    public static int smash(int[] a) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : a) q.add(x);
        while (q.size() > 1) {
            int x = q.poll(), y = q.poll();
            if (x != y) q.add(x - y);
        } return q.isEmpty() ? 0 : q.poll();
    }
}