import java.util.*;

class Solution {
    public String footballWinner(String[] goals) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String team : goals) {
            map.put(team, map.getOrDefault(team, 0) + 1);
        }
        String winner = "";
        int maxGoals = 0;

        for (String team : map.keySet()) {
            if (map.get(team) > maxGoals) {
                maxGoals = map.get(team);
                winner = team;
            }
        }

        return winner;
    }
}