public class Question1_Leetcode{
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        int required = tickets[k];

        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                time += Math.min(tickets[i], required);
            } else {
                time += Math.min(tickets[i], required - 1);
            }
        }
        return time;      
    }
}