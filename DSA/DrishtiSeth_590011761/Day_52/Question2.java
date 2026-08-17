import java.util.HashMap;
import java.util.Scanner;

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
                System.out.println(username + map.get(username));
                map.put(username, map.get(username) + 1);
            }
        }

        sc.close();
    }
}
