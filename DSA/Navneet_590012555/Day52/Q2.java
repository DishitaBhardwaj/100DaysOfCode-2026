class Solution {
    public String[] register(String[] names) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] ans = new String[names.length];

        for (int i = 0; i < names.length; i++) {
            String s = names[i];

            if (!map.containsKey(s)) {
                ans[i] = "OK";
                map.put(s, 1);
            } else {
                String t = s + map.get(s);
                ans[i] = t;
                map.put(s, map.get(s) + 1);
                map.put(t, 1);
            }
        }

        return ans;
    }
}