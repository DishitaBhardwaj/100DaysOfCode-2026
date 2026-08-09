import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();

            if (!map.containsKey(name)) {
                System.out.println("OK");
                map.put(name, 1);
            } else {
                int count = map.get(name);
                System.out.println(name + count);
                map.put(name, count + 1);
            }
        }

        sc.close();
    }
}
