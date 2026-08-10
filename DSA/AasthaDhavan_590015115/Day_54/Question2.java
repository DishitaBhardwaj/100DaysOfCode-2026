import java.util.*;

class Solution {
    public String footballChampion(String[] goals) {
        HashMap<String, Integer> map = new HashMap<>();

        String winner = "";
        int maxGoals = 0;

        for (String team : goals) {
            map.put(team, map.getOrDefault(team, 0) + 1);

            if (map.get(team) > maxGoals) {
                maxGoals = map.get(team);
                winner = team;
            }
        }

        return winner;
    }
}