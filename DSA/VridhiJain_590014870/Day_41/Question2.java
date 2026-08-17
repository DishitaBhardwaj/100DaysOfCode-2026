import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String jobs = sc.next();
        Queue<Integer> sales = new LinkedList<>();
        Queue<Integer> marketing = new LinkedList<>();
        int n = jobs.length();
        for (int i = 0; i < n; i++) {
            if (jobs.charAt(i) == 'S') {
                sales.add(i);
            } else {
                marketing.add(i);
            }
        }
        while (!sales.isEmpty() && !marketing.isEmpty()) {
            int s = sales.remove();
            int m = marketing.remove();
            if (s < m) {
                sales.add(s + n);
            } else {
                marketing.add(m + n);
            }
        }
        if (sales.isEmpty()) {
            System.out.println("Marketing");
        } else {
            System.out.println("Sales");
        }
    }
}