package HashMap;

import java.util.HashMap;

public class Football_Championship {

    public static String WinningTeam( String[] teams){

        HashMap<String, Integer> teamScores = new HashMap<>();

        String winner = "";
        int maxgoals = 0;

        for( String team_name : teams ){
            int count = teamScores.getOrDefault(team_name, 0) + 1;
            teamScores.put(team_name, count);

            if( count > maxgoals ){
                maxgoals = count;
                winner = team_name;
            }
        }
        return winner;
    }

    public static void main( String[] args ) {

        String[] goals = {"A", "ABA", "ABA", "A", "A"};

        String winner = WinningTeam(goals);
        System.out.println("The winning team is: " + winner);
    }
    
}
