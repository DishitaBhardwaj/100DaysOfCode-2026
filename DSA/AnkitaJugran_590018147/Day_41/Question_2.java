package Queue;
import java.util.*;

public class OfficePrinterWar {

    public static String winner(String jobs) {

        Queue<Integer> sales = new LinkedList<>();
        Queue<Integer> marketing = new LinkedList<>();

        int n = jobs.length();

        // Store positions of Sales and Marketing jobs
        for (int i = 0; i < n; i++) {
            if (jobs.charAt(i) == 'S') {
                sales.offer(i);
            } else {
                marketing.offer(i);
            }
        }

        // Continue until one department has no jobs left
        while (!sales.isEmpty() && !marketing.isEmpty()) {

            int s = sales.poll();
            int m = marketing.poll();

            if (s < m) {
                // Sales acts first and cancels Marketing
                sales.offer(s + n);
            } else {
                // Marketing acts first and cancels Sales
                marketing.offer(m + n);
            }
        }

        return sales.isEmpty() ? "Marketing" : "Sales";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String jobs = sc.next();

        System.out.println(winner(jobs));

        sc.close();
    }
}