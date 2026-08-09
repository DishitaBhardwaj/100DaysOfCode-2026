import java.util.*;

class Solution {

    public static List<String> registerUsers(String[] usernames) {

        HashMap<String, Integer> used = new HashMap<>();
        List<String> answer = new ArrayList<>();

        for (String username : usernames) {

            if (!used.containsKey(username)) {
                answer.add("OK");
                used.put(username, 1);
            } else {

                int num = used.get(username);

                while (used.containsKey(username + num)) {
                    num++;
                }

                String newUsername = username + num;

                answer.add(newUsername);

                used.put(username, num + 1);
                used.put(newUsername, 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        String[] requests = {
            "john", "john", "mary", "john", "mary", "john"
        };

        List<String> result = registerUsers(requests);

        for (String s : result) {
            System.out.println(s);
        }
    }
}
