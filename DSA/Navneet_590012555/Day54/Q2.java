class Solution {
    public String winner(String[] goals) {
        HashMap<String, Integer> map = new HashMap<>();

        String ans = "";
        int max = 0;

        for (String team : goals) {
            map.put(team, map.getOrDefault(team, 0) + 1);

            if (map.get(team) > max) {
                max = map.get(team);
                ans = team;
            }
        }

        return ans;
    }
}