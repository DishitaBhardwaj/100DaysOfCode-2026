import java.util.*;

public class Main {

    public static String winningTeam(String[] goals) {
        String team1 = goals[0];
        String team2 = null;

        int count1 = 0;
        int count2 = 0;

        for (String goal : goals) {
            if (goal.equals(team1)) {
                count1++;
            } else {
                if (team2 == null) {
                    team2 = goal;
                }
                count2++;
            }
        }

        return count1 > count2 ? team1 : team2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of goals: ");
        int n = sc.nextInt();

        String[] goals = new String[n];

        System.out.println("Enter team name for each goal:");
        for (int i = 0; i < n; i++) {
            goals[i] = sc.next();
        }

        System.out.println("Winning Team: " + winningTeam(goals));

        sc.close();
    }
}