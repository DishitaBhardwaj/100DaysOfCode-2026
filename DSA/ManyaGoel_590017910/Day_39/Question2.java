import java.util.*;
public class Question2 {
    public static int minRooms(int[][] intervals ){

        if(intervals == null || intervals.length ==0) return 0;
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (!pq.isEmpty() && start >= pq.peek()) {
                pq.poll();
            }
            pq.offer(end);
        }
        return pq.size();
    }
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of meetings: ");
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        
        System.out.println("Enter the start and end time of each meeting:");
        for (int i = 0; i < n; i++) {
            System.out.print("Meeting " + (i + 1) + ": ");
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        System.out.println("Minimum Conference Rooms Required = " + minRooms(intervals));
        sc.close();
    }
}