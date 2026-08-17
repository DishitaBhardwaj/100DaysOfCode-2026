package DSA.TanmaySharma_590011578.Day_39;
import java.util.*;

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Question2 {

    public static int minRooms(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> a.start - b.start);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Interval interval : intervals) {
            if (!pq.isEmpty() && pq.peek() <= interval.start) {
                pq.poll();
            }
            pq.offer(interval.end);
        }

        return pq.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Interval[] intervals = new Interval[n];

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            intervals[i] = new Interval(start, end);
        }

        System.out.println(minRooms(intervals));
    }
}