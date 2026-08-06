import java.util.*;

class Question2 {
    public static List<String> usernameSystem(String[] requests) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();

        for (String name : requests) {
            if (!map.containsKey(name)) {
                ans.add("OK");
                map.put(name, 1);
            } else {
                String newName = name + map.get(name);
                ans.add(newName);

                map.put(name, map.get(name) + 1);
                map.put(newName, 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] requests = {"abacaba", "acaba", "abacaba", "acab"};
        System.out.println(usernameSystem(requests));
    }
}