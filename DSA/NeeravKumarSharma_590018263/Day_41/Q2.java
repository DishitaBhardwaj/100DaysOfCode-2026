import java.util.LinkedList;
import java.util.Queue;

public class Q2 {

    public static void main(String[] args) {
        String jobs = "SMM";
        System.out.println("Output: " + predictWinner(jobs));
    }

    public static String predictWinner(String jobs) {
        Queue<Integer> salesQueue = new LinkedList<>();
        Queue<Integer> marketingQueue = new LinkedList<>();
        int n = jobs.length();

        for (int i = 0; i < n; i++) {
            if (jobs.charAt(i) == 'S') {
                salesQueue.add(i);
            } else if (jobs.charAt(i) == 'M') {
                marketingQueue.add(i);
            }
        }

        while (!salesQueue.isEmpty() && !marketingQueue.isEmpty()) {
            int salesIndex = salesQueue.poll();
            int marketingIndex = marketingQueue.poll();

            if (salesIndex < marketingIndex) {
                salesQueue.add(salesIndex + n);
            } else {
                marketingQueue.add(marketingIndex + n);
            }
        }

        if (salesQueue.isEmpty()) {
            return "Marketing";
        } else {
            return "Sales";
        }
    }
}