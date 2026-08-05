import java.util.*;

class Solution {
    public int firstInvalidRecord(int[][] records) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < records.length; i++) {
            int vendor = records[i][0];
            int lot = records[i][1];
            int cert = records[i][2];

            String key = vendor + "#" + lot;

            if (!map.containsKey(key)) {
                map.put(key, cert);
            } else {
                if (map.get(key) != cert) {
                    return i;
                }
            }
        }

        return -1;
    }
}