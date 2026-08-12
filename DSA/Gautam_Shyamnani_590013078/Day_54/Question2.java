public class Question2 {

    public static String winner(String[] goals) {
        String team1 = goals[0];
        String team2 = "";
        int count1 = 0, count2 = 0;

        for (String team : goals) {
            if (team.equals(team1)) {
                count1++;
            } else {
                team2 = team;
                count2++;
            }
        }
        return (count1 > count2) ? team1 : team2;
    }

    public static void main(String[] args) {
        String[] goals = {"LIONS", "TIGERS", "LIONS", "LIONS"};
        System.out.println(winner(goals)); 
    }
}