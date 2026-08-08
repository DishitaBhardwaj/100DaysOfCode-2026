class Solution {
    public long maxPleasure(int[] length, int[] beauty, int k) {
        int n = length.length;

        int[][] songs = new int[n][2];
        for (int i = 0; i < n; i++) {
            songs[i][0] = beauty[i];
            songs[i][1] = length[i];
        }

        Arrays.sort(songs, (a, b) -> b[0] - a[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0, ans = 0;

        for (int[] s : songs) {
            pq.offer(s[1]);
            sum += s[1];

            if (pq.size() > k)
                sum -= pq.poll();

            ans = Math.max(ans, sum * s[0]);
        }

        return ans;
    }
}