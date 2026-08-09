import java.io.*;
import java.util.HashMap;

public class Question2 {
    public static String[] registerUsers(String[] requests) {
        HashMap<String, Integer> userMap = new HashMap<>(requests.length * 2);
        String[] result = new String[requests.length];
        for (int i = 0; i < requests.length; i++) {
            String user = requests[i];
            if (!userMap.containsKey(user)) {
                userMap.put(user, 1);
                result[i] = "OK";
            } else {
                int suffix = userMap.get(user);
                String newUser = user + suffix;
                while (userMap.containsKey(newUser)) {
                    suffix++;
                    newUser = user + suffix;
                }
                userMap.put(user, suffix + 1);
                userMap.put(newUser, 1);
                result[i] = newUser;
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter number of registration requests: ");
        int n = Integer.parseInt(br.readLine().trim());

        String[] requests = new String[n];
        System.out.println("Enter the usernames:");
        for (int i = 0; i < n; i++) {
            requests[i] = br.readLine().trim();
        }
        System.out.println("Requests: [\"" + String.join("\", \"", requests) + "\"]");
        String[] result = registerUsers(requests);
        System.out.println("\nRegistration Results:");
        for (String r : result) {
            System.out.println(r);
        }
        br.close();
    }
}