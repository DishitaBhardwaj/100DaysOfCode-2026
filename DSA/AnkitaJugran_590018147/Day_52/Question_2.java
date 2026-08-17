package HashMap;

import java.util.HashMap;

public class RegistrationSystem {
    
    public static void registerUsers(String[] requests) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String username : requests) {

            // Username is available
            if (!map.containsKey(username)) {
                System.out.println("OK");
                map.put(username, 1);
            } else {
                // Username already exists
                int suffix = map.get(username);
                String newUsername = username + suffix;

                // In case the generated username already exists,
                // keep increasing the suffix until it becomes unique.
                while (map.containsKey(newUsername)) {
                    suffix++;
                    newUsername = username + suffix;
                }

                System.out.println(newUsername);

                // Update next suffix for the original username
                map.put(username, suffix + 1);

                // Mark the new username as used
                map.put(newUsername, 1);
            }
        }
    }

    public static void main(String[] args) {

        String[] requests = {
                "john",
                "john",
                "john",
                "john"
        };

        registerUsers(requests);
    }
}
