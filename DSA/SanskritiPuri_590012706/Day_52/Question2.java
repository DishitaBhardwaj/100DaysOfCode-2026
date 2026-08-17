import java.util.*;

public class Solution {

    public static List<String> usernameRegistration(String[] requests) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (String username : requests) {

            if (!map.containsKey(username)) {
                result.add("OK");
                map.put(username, 1);
            } else {
                int count = map.get(username);
                String newUsername = username + count;

                while (map.containsKey(newUsername)) {
                    count++;
                    newUsername = username + count;
                }

                result.add(newUsername);

                map.put(username, count + 1);
                map.put(newUsername, 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        String[] requests1 = {"abacaba", "acaba", "abacaba", "acab"};
        System.out.println(usernameRegistration(requests1));

        String[] requests2 = {"first", "first", "second", "second", "third", "third"};
        System.out.println(usernameRegistration(requests2));

        String[] requests3 = {"john", "john", "john", "john"};
        System.out.println(usernameRegistration(requests3));
    }
}
