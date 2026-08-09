import java.util.*;

public class Solution {

    public static String officePrinterWars(String jobs) {
        Queue<Integer> sales = new LinkedList<>();
        Queue<Integer> marketing = new LinkedList<>();

        int n = jobs.length();

        // Store indices of Sales and Marketing jobs
        for (int i = 0; i < n; i++) {
            if (jobs.charAt(i) == 'S') {
                sales.offer(i);
            } else {
                marketing.offer(i);
            }
        }

        // Process until one department has no jobs left
        while (!sales.isEmpty() && !marketing.isEmpty()) {
            int s = sales.poll();
            int m = marketing.poll();

            if (s < m) {
                // Sales acts first and survives
                sales.offer(s + n);
            } else {
                // Marketing acts first and survives
                marketing.offer(m + n);
            }
        }

        return sales.isEmpty() ? "Marketing" : "Sales";
    }

    public static void main(String[] args) {
        System.out.println(officePrinterWars("SM"));   // Sales
        System.out.println(officePrinterWars("SMM"));  // Marketing
        System.out.println(officePrinterWars("MSS"));  // Sales
    }
}