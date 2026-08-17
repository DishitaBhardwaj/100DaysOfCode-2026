import java.util.*;

class Question2 {
    public String officePrinterWars(String jobs) {
        Queue<Integer> s = new LinkedList<>();
        Queue<Integer> m = new LinkedList<>();

        for (int i = 0; i < jobs.length(); i++) {
            if (jobs.charAt(i) == 'S')
                s.offer(i);
            else
                m.offer(i);
        }

        int n = jobs.length();

        while (!s.isEmpty() && !m.isEmpty()) {
            int a = s.poll(), b = m.poll();
            if (a < b)
                s.offer(a + n);
            else
                m.offer(b + n);
        }

        return s.isEmpty() ? "Marketing" : "Sales";
    }
}