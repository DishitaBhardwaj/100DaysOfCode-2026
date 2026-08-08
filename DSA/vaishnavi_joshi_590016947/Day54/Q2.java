import java.util.HashMap;

class Solution {
    public String winner(String[] goals) {
        HashMap<String, Integer> map = new HashMap<>();

        // Count goals scored by each team
        for (String team : goals) {
            map.put(team, map.getOrDefault(team, 0) + 1);
        }

        String winner = "";
        int maxGoals = 0;

        // Find the team with the maximum goals
        for (String team : map.keySet()) {
            if (map.get(team) > maxGoals) {
                maxGoals = map.get(team);
                winner = team;
            }
        }

        return winner;
    }
}