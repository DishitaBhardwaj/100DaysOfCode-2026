package Day_39;

import java.util.*;

public class d39question2_technical {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            System.out.print("s: ");
            arr[i][0] = sc.nextInt();
            System.out.print("e: ");
            arr[i][1] = sc.nextInt();
        }

        System.out.println("Rooms: " + minRooms(arr));
        sc.close();
    }

    public static int minRooms(int[][] arr) {
        if (arr.length == 0) return 0;

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int r = 0;

        for (int[] m : arr) {
            if (!pq.isEmpty() && pq.peek() <= m[0]) pq.poll();
            pq.offer(m[1]);
            r = Math.max(r, pq.size());
        }
        return r;
    }
}
