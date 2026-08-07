import java.util.HashMap;
public class Question2 {
    public static String solve(String[] a) {
        HashMap<String, Integer> m = new HashMap<>();
        String s = "";
        int x = 0;
        for (String i : a) if (m.merge(i, 1, Integer::sum) > x) {
            x = m.get(i); s = i;
        } return s;
    }
}