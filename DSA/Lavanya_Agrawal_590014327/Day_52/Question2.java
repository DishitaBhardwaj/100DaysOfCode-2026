import java.util.*;

public class Question2 {

    public static void registerUsers(String[] requests) {

        HashMap<String, Integer> map = new HashMap<>();

        for (String username : requests) {

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
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] requests = new String[n];

        for (int i = 0; i < n; i++) {
            requests[i] = sc.next();
        }

        registerUsers(requests);

        sc.close();
    }
}