import java.util.*;

public class Question2 {

    public static String findWinner(String[] goals) {

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

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] goals = new String[n];

        for (int i = 0; i < n; i++) {
            goals[i] = sc.next();
        }

        System.out.println(findWinner(goals));

        sc.close();
    }
}
