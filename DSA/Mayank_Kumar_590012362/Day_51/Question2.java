import java.util.HashMap;
public class Question2 {
    public static int solution(String[][] a) {
        HashMap<String, String> m = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            String k = a[i][0] + "#" + a[i][1];
            String c = a[i][2];
            if (m.containsKey(k)) {
                if (!m.get(k).equals(c)) return i;
            } else m.put(k, c);
        } return -1;
    }
}