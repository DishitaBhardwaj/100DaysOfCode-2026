class Solution {
    public long maxPleasure(int[] length, int[] beauty, int k) {

        int n = length.length;

        int[][] songs = new int[n][2];

        for (int i = 0; i < n; i++) {
            songs[i][0] = beauty[i];
            songs[i][1] = length[i];
        }

        Arrays.sort(songs, (a, b) -> Integer.compare(b[0], a[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long sum = 0;
        long answer = 0;

        for (int i = 0; i < n; i++) {

            int currentBeauty = songs[i][0];
            int currentLength = songs[i][1];

            pq.offer(currentLength);
            sum += currentLength;

            if (pq.size() > k) {
                sum -= pq.poll();
            }

            answer = Math.max(answer, sum * currentBeauty);
        }

        return answer;
    }
}