package DSA.TanmaySharma_590011578.Day_41;
import java.util.*;

public class Question2 {

    public static String findWinner(String jobs) {
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

        if (!sales.isEmpty()) {
            return "Sales";
        }

        return "Marketing";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String jobs = sc.nextLine();

        System.out.println(findWinner(jobs));
    }
}