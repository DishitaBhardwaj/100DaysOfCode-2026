import java.util.*;

class Solution {
    public String winner(String[] goals) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String team : goals) {
            map.put(team, map.getOrDefault(team, 0) + 1);
        }

        String winner = "";
        int maxGoals = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxGoals) {
                maxGoals = entry.getValue();
                winner = entry.getKey();
            }
        }

        return winner;
    }
}