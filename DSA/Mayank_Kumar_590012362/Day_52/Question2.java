public class Question2 {
    public static String[] solve(String[] a) {
        java.util.HashMap<String, Integer> m = new java.util.HashMap<>();
        String[] r = new String[a.length];
        for (int i = 0; i < a.length; i++) {
            String s = a[i];
            if (!m.containsKey(s)) {
                r[i] = "OK";
                m.put(s, 1);
            } else {
                int x = m.get(s);
                String t = s + x;
                while (m.containsKey(t)) t = s + (++x);
                r[i] = t;
                m.put(s, x + 1);
                m.put(t, 1);
            }
        } return r;
    }
}