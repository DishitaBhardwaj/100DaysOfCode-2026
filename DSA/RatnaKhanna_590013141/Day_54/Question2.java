import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static String findWinner(String[] goals) {
        HashMap<String, Integer> map = new HashMap<>();

        // Count goals for each team
        for (String team : goals) {
            map.put(team, map.getOrDefault(team, 0) + 1);
        }

        // Find team with maximum goals
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of goals scored
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        String[] goals = new String[n];

        // Team name for each goal
        for (int i = 0; i < n; i++) {
            goals[i] = sc.nextLine();
        }

        System.out.println(findWinner(goals));

        sc.close();
    }
}
