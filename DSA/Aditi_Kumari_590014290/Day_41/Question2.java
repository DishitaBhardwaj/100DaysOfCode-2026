package Day_41;
import java.util.*;
public class Question2 {
     public String printerWars(String jobs) {

        Queue<Integer> sales = new ArrayDeque<>();
        Queue<Integer> marketing = new ArrayDeque<>();

        int n = jobs.length();
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
