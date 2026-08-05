import java.util.HashMap;

class Solution {

    public int validateLogs(String[][] records) {

        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < records.length; i++) {

            String key = records[i][0] + "#" + records[i][1];
            String cert = records[i][2];

            if (map.containsKey(key)) {
                if (!map.get(key).equals(cert)) {
                    return i;
                }
            } else {
                map.put(key, cert);
            }
        }

        return -1;
    }
}