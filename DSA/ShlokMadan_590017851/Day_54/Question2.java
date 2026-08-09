import java.util.*;
public class Question2 
{
    public static String winner(String[] goals) 
    {
        HashMap<String, Integer> map = new HashMap<>();
        for (String team : goals) 
            {
            map.put(team, map.getOrDefault(team, 0) + 1);
        }
        String winner = "";
        int maxGoals = 0;
        for (String team : map.keySet()) 
            {
            if (map.get(team) > maxGoals) 
                {
                maxGoals = map.get(team);
                winner = team;
            }
        }
        return winner;
    }
    public static void main(String[] args) 
    {
        String[] goals = {"A", "ABA", "ABA", "A", "A"};
        System.out.println(winner(goals));
    }
}