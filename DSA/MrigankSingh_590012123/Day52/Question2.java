import java.util.HashMap;
import java.util.Map;

public class Question2 {
    public String[] registerUsernames(String[] requests) {
        Map<String, Integer> nextSuffix = new HashMap<>();
        String[] result = new String[requests.length];

        for (int i = 0; i < requests.length; i++) {
            String name = requests[i];

            if (!nextSuffix.containsKey(name)) {
                result[i] = "OK";
                nextSuffix.put(name, 1);
            } else {
                int suffix = nextSuffix.get(name);
                String candidate = name + suffix;

                while (nextSuffix.containsKey(candidate)) {
                    suffix++;
                    candidate = name + suffix;
                }

                result[i] = candidate;
                nextSuffix.put(name, suffix + 1);
                nextSuffix.put(candidate, 1);
            }
        }

        return result;
    }
}