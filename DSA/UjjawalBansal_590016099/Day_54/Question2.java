import java.util.Scanner;
import java.util.Arrays;

public class Question2 {
    public static String footballChampionWinner(String[] goals) {
        String t1 = goals[0];
        int c1 = 0;
        String t2 = null;
        int c2 = 0;

        for (String goal : goals) {
            if (goal.equals(t1)) {
                c1++;
            } 
            else {
                t2 = goal;
                c2++;
            }
        }
        return c1 > c2 ? t1 : t2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total number of goals scored: ");
        int n = sc.nextInt();

        String[] goals = new String[n];
        System.out.println("Enter the team name for each of the " + n + " goals:");
            
        for (int i = 0; i < n; i++) {
            goals[i] = sc.nextLine();
        }

        System.out.println("Match Goals: " + Arrays.toString(goals));
        String winner = footballChampionWinner(goals);
        System.out.println("The winning team is: " + winner);
        sc.close();
    }
}
