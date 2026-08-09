import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Question_2 {

    public static String printerWars(String jobs) {

        Queue<Integer> sales = new LinkedList<>();
        Queue<Integer> marketing = new LinkedList<>();

        for (int i = 0; i < jobs.length(); i++) {

            if (jobs.charAt(i) == 'S') {
                sales.add(i);
            } else {
                marketing.add(i);
            }
        }

        int n = jobs.length();

        while (!sales.isEmpty() && !marketing.isEmpty()) {

            int s = sales.poll();
            int m = marketing.poll();

            if (s < m) {
                sales.add(s + n);
            } else {
                marketing.add(m + n);
            }
        }

        if (!sales.isEmpty()) {
            return "Sales";
        } else {
            return "Marketing";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the jobs (S for Sales, M for Marketing): ");
        String jobs = sc.nextLine();

        String result = printerWars(jobs);

        System.out.println("Last remaining department: " + result);

        sc.close();
    }
}