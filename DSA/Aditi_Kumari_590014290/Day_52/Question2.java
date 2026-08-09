package Day_52;
import java.util.*;
public class Question2 {
    public String[] registerUsers(String[] usernames) {

        HashMap<String, Integer> map = new HashMap<>();
        String[] ans = new String[usernames.length];

        for (int i = 0; i < usernames.length; i++) {
            String name = usernames[i];
            if (!map.containsKey(name)) {
                ans[i] = "OK";
                map.put(name, 1);
            } else {
                int count = map.get(name);
                String newName = name + count;
                ans[i] = newName;
                map.put(name, count + 1);
                map.put(newName, 1);
            }
        }

        return ans;
    }
}
