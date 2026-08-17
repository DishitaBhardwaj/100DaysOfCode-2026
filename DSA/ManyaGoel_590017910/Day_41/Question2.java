import java.util.*;
public class Question2 {
    public static String printerWinner( String jobs ){
        Queue<Integer> sales = new LinkedList<>();
        Queue<Integer> market = new LinkedList<>();
        int n = jobs.length();
        for (int i = 0; i < n; i++) {
            if (jobs.charAt(i) == 'S') {
                sales.offer(i);
            } else {
                market.offer(i);
            }
        }

        while (!sales.isEmpty() && !market.isEmpty()) {
            int salesIndex = sales.poll();
            int marketIndex = market.poll();

            if (salesIndex < marketIndex) {
                sales.offer(salesIndex + n);
            } else {
                market.offer(marketIndex + n);
            }
        }
        if (sales.isEmpty()) {
            return "Marketing";
        }
        return "Sales";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the job sequence: ");
        String jobs = sc.next();
        System.out.println("Jobs:" + "\"" + jobs + "\"");
        String winner = printerWinner(jobs);
        System.out.println("Winning Department: " + winner);
        sc.close();
    }
}