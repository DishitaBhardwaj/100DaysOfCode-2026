
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Question2 {

    // Function to find the winning team
    public static String getWinner(String[] goals) {
        // Create a HashMap to store (Team Name -> Goal Count)
        Map<String, Integer> goalCounts = new HashMap<>();

        // Loop through every goal in the array
        for (String team : goals) {
            // Get current goals for the team (default to 0 if not scored yet) and add 1
            int newScore = goalCounts.getOrDefault(team, 0) + 1;

            // Update the count in the map
            goalCounts.put(team, newScore);
        }

        // Variables to track the winner and maximum goals scored
        String winner = "";
        int maxGoals = -1;

        // Loop through the map to find which team scored the most goals
        for (Map.Entry<String, Integer> entry : goalCounts.entrySet()) {
            if (entry.getValue() > maxGoals) {
                maxGoals = entry.getValue(); // Update highest goal count
                winner = entry.getKey();     // Update winning team name
            }
        }

        // Return the winning team's name
        return winner;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the total number of goals
        System.out.print("Enter total number of goals scored in the match: ");
        int n = scanner.nextInt();

        // Create an array to store the goal scorers
        String[] goals = new String[n];

        // Take inputs for each goal scored
        System.out.println("Enter team names for each goal:");
        for (int i = 0; i < n; i++) {
            goals[i] = scanner.next();
        }

        // Call the function and get the result
        String winner = getWinner(goals);

        // Display the final winner
        System.out.println("Winner: " + winner);

        scanner.close();
    }
}
