import java.util.HashMap;
import java.util.Map;

public class Question2 {
    public String footballChampionshipWinner(String[] goals) {
        Map<String, Integer> scores = new HashMap<>();

        for (String goal : goals) {
            scores.put(goal, scores.getOrDefault(goal, 0) + 1);
        }

        String winner = "";
        int bestScore = -1;

        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            if (entry.getValue() > bestScore) {
                bestScore = entry.getValue();
                winner = entry.getKey();
            }
        }

        return winner;
    }
}