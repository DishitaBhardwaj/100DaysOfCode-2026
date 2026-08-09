import java.util.*;

class Solution {

    public static String winner(List<String> goals) {

        HashMap<String, Integer> count = new HashMap<>();

        for (String team : goals) {
            if (count.containsKey(team)) {
                count.put(team, count.get(team) + 1);
            } else {
                count.put(team, 1);
            }
        }

        String ans = "";
        int max = 0;

        for (String team : count.keySet()) {
            if (count.get(team) > max) {
                max = count.get(team);
                ans = team;
            }
        }

        return ans;
    }
}
