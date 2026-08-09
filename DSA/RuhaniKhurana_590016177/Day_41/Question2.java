import java.util.*;

class Question2 {

    public String printerWars(String jobs) {

        int n = jobs.length();

        Queue<Integer> a = new LinkedList<>();
        Queue<Integer> b = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (jobs.charAt(i) == 'A')
                a.offer(i);
            else
                b.offer(i);
        }

        while (!a.isEmpty() && !b.isEmpty()) {

            int a1 = a.poll();
            int b1 = b.poll();

            if (a1 < b1) {
                a.offer(a1 + n);
            } else {
                b.offer(b1 + n);
            }
        }

        return a.isEmpty() ? "Business" : "Accounting";
    }
}