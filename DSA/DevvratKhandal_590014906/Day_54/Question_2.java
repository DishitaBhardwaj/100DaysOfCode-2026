import java.util.*;
public class Question_2 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of goals: ");
        int n = sc.nextInt();
        sc.nextLine();

        HashMap<String, Integer> map = new HashMap<>();

        System.out.println("Enter team name for each goal:");
        for (int i = 0; i < n; i++) {
            String team = sc.nextLine();
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

        System.out.println("Winner: " + winner);
    }

}
