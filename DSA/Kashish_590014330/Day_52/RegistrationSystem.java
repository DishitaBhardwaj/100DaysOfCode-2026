import java.util.*;

public class RegistrationSystem {
    public static List<String> getRegistrationStatus(List<String> requests) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (String name : requests) {
            if (!map.containsKey(name)) {
                result.add("OK");
                map.put(name, 1);
            } else {
                int count = map.get(name);
                result.add(name + count);
                map.put(name, count + 1);
            }
        }

        return result;
    }
}