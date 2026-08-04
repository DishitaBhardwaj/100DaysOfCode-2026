import java.util.HashMap;

class Solution {
    public int firstInvalidRecord(String[][] records) {

        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < records.length; i++) {

            String key = records[i][0] + "-" + records[i][1];
            String cert = records[i][2];

            if (!map.containsKey(key)) {
                map.put(key, cert);
            } else {
                if (!map.get(key).equals(cert)) {
                    return i;
                }
            }
        }

        return -1;
    }
}
