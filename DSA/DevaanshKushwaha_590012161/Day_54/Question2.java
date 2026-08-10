class Solution {
    public String winningTeam(String[] goals) {
        // Step 1: Count goals per team
        Map<String, Integer> freqMap = new HashMap<>();
        for (String team : goals) {
            freqMap.put(team, freqMap.getOrDefault(team, 0) + 1);
        }
        
        // Step 2: Find team with maximum goal count
        String winner = "";
        int maxGoals = 0;
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > maxGoals) {
                maxGoals = entry.getValue();
                winner = entry.getKey();
            }
        }
        
        return winner;
    }
}
