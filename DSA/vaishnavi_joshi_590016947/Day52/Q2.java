import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashMap<String, Integer> map = new HashMap<>();

        while (n-- > 0) {
            String username = sc.next();

            if (!map.containsKey(username)) {
                System.out.println("OK");
                map.put(username, 1);
            } else {
                int count = map.get(username);
                System.out.println(username + count);
                map.put(username, count + 1);
            }
        }

        sc.close();
    }
}