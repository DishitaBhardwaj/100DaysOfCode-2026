package DSA.TanmaySharma_590011578.Day_54;
import java.util.*;

public class Question2 {
    public static String findWinner(String[] teams) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String team : teams) {
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

    public static void main(String[] args) {
        String[] teams = {"A", "ABA", "ABA", "A", "A"};
        System.out.println(findWinner(teams));
    }
}