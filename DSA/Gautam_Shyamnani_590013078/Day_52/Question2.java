import java.util.*;

public class Question2 {

    static HashMap<String, Integer> map = new HashMap<>();

    static String getUsername(String name) {
        if (!map.containsKey(name)) {
            map.put(name, 1);
            return "OK";
        }

        int count = map.get(name);
        String newName = name + count;

        getUsername(newName); 
        map.put(name, count + 1);

        return newName;
    }

    public static void main(String[] args) {

        String[] requests = {"john", "john", "john", "john"};

        for (String username : requests) {
            System.out.println(getUsername(username));
        }
    }
}