import java.util.Scanner;

public class Question2 {
    public static String findWinner(String[] goals) {
        String first = goals[0];
        String second = null;
        int difference = 0;

        for (String team : goals) {
            if (team.equals(first)) {
                difference++;
            } else {
                second = team;
                difference--;
            }
        }
        return difference > 0 ? first : second;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of goals: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        String[] goals = new String[n];
        System.out.println("Enter the team name for each goal:");
        for (int i = 0; i < n; i++) {
            goals[i] = sc.nextLine().trim();
        }
        System.out.println("goals = [\"" + String.join("\", \"", goals) + "\"]");
        String winner = findWinner(goals);
        System.out.println("Winner: " + winner);

        sc.close();
    }
}