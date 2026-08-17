import java.util.*;

class Solution {
    public List<String> processRegistrations(List<String> requests) {
        Set<String> used = new HashSet<>();          // all usernames currently taken
        Map<String, Integer> nextSuffix = new HashMap<>(); // base -> next suffix to try
        List<String> result = new ArrayList<>();

        for (String name : requests) {
            if (!used.contains(name)) {
                // Username is free — take it as-is
                used.add(name);
                nextSuffix.putIfAbsent(name, 1);
                result.add("OK");
            } else {
                // Find smallest k such that name+k is free
                int k = nextSuffix.getOrDefault(name, 1);
                String candidate = name + k;
                while (used.contains(candidate)) {
                    k++;
                    candidate = name + k;
                }
                used.add(candidate);
                nextSuffix.put(name, k + 1); // resume from here next time
                result.add(candidate);
            }
        }
        return result;
    }
}
