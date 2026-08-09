class Solution {
    public int[] getFinalState(int[] a, int k, int m) {
        PriorityQueue<int[]> q = new PriorityQueue<>((x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);
        for (int i = 0; i < a.length; i++) q.add(new int[] { a[i], i });
        while (k-- > 0) {
            int[] t = q.poll();
            t[0] *= m;
            a[t[1]] = t[0];
            q.add(t);
        } return a;
    }
}