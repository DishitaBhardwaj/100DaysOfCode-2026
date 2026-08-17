import java.util.ArrayDeque;
public class Question2 {
    public String printerWars(String s) {
        int n = s.length();
        ArrayDeque<Integer> a = new ArrayDeque<>(), b = new ArrayDeque<>();
        for (int i = 0; i < n; i++)
            if (s.charAt(i) == 'S') a.add(i);
            else b.add(i);
        while (!a.isEmpty() && !b.isEmpty()) {
            int x = a.poll(), y = b.poll();
            if (x < y) a.add(x + n);
            else b.add(y + n);
        }
        return a.isEmpty() ? "Marketing" : "Sales";
    }
}