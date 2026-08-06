import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            String username = sc.next();

            if (!map.containsKey(username)) {
                System.out.println("OK");
                map.put(username, 1);
            } else {

                int count = map.get(username);
                String newUsername = username + count;

                while (map.containsKey(newUsername)) {
                    count++;
                    newUsername = username + count;
                }

                System.out.println(newUsername);

                map.put(username, count + 1);
                map.put(newUsername, 1);
            }
        }

        sc.close();
    }
}
