import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            pq.offer(sc.nextInt());
        }

        while (pq.size() > 1) {
            int diff = pq.poll() - pq.poll();
            if (diff > 0) pq.offer(diff);
        }

        System.out.println(pq.isEmpty() ? 0 : pq.peek());

        sc.close();
    }
}