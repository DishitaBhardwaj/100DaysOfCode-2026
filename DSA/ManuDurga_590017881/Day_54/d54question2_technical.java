package Day_54;

import java.util.*;

public class d54question2_technical {
    public static String winningTeam(String[] goals) {
        Map<String, Integer> score = new HashMap<>();

        for (String team : goals) {
            score.put(team, score.getOrDefault(team, 0) + 1);
        }

        // Since there are at most two teams and no draw, just compare
        String winner = null;
        int maxGoals = -1;
        for (Map.Entry<String, Integer> entry : score.entrySet()) {
            if (entry.getValue() > maxGoals) {
                maxGoals = entry.getValue();
                winner = entry.getKey();
            }
        }

        return winner;
    }
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of Array: ");
        int n1 = sc.nextInt();
        sc.nextLine();
        String[] Arr1 = new String[n1];
        for(int i=0;i<n1;i++){
            System.out.print(": ");
            Arr1[i]=sc.nextLine();}
        System.out.println(winningTeam(Arr1));
        sc.close();}}
