
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question2 {

    // Function to find the winning department
    public static String printerWars(String jobs) {

        // Queue for Sales jobs
        Queue<Integer> sales = new LinkedList<>();

        // Queue for Marketing jobs
        Queue<Integer> marketing = new LinkedList<>();

        int n = jobs.length();

        // Store the positions of each job
        for (int i = 0; i < n; i++) {

            if (jobs.charAt(i) == 'S') {
                sales.offer(i);
            } else {
                marketing.offer(i);
            }
        }

        // Continue until one department has no jobs left
        while (!sales.isEmpty() && !marketing.isEmpty()) {

            // Get front positions
            int s = sales.poll();
            int m = marketing.poll();

            // Sales gets the turn first
            if (s < m) {

                // Sales survives and comes back later
                sales.offer(s + n);
            } // Marketing gets the turn first
            else {

                // Marketing survives and comes back later
                marketing.offer(m + n);
            }
        }

        // Winner
        if (sales.isEmpty()) {
            return "Marketing";
        } else {
            return "Sales";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input jobs
        System.out.print("Enter jobs (S and M): ");
        String jobs = sc.next();

        // Find winner
        String winner = printerWars(jobs);

        // Print answer
        System.out.println("Winning Department = " + winner);

        sc.close();
    }
}
