package DSA.Saransh_590024524.Day41;

import java.util.LinkedList;
import java.util.Queue;

public class Question2 {

    public String officePrinterWars(String jobs) {

        Queue<Integer> sales = new LinkedList<>();
        Queue<Integer> marketing = new LinkedList<>();

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

