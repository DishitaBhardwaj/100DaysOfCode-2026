import java.util.LinkedList;
import java.util.Queue;

public class Problem2 {
    public String officePrinterWars(String jobs) {
        int n = jobs.length();
        Queue<Integer> sales = new LinkedList<>();
        Queue<Integer> marketing = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (jobs.charAt(i) == 'S') {
                sales.offer(i);
            } else {
                marketing.offer(i);
            }
        }

        while (!sales.isEmpty() && !marketing.isEmpty()) {
            int s = sales.poll();
            int m = marketing.poll();

            if (s < m) {
                sales.offer(s + n);
            } else {
                marketing.offer(m + n);
            }
        }

        return sales.isEmpty() ? "Marketing" : "Sales";
    }
}