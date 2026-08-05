import java.util.*;

public class Solution {
    public int firstInvalidRecord(List<List<String>> deliveries) {
        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < deliveries.size(); i++) {
            List<String> record = deliveries.get(i);

            String vendorId = record.get(0);
            String lotNumber = record.get(1);
            String certCode = record.get(2);

            String key = vendorId + "#" + lotNumber;

            if (!map.containsKey(key)) {
                map.put(key, certCode);
            } else {
                if (!map.get(key).equals(certCode)) {
                    return i;
                }
            }
        }

        return -1;
    }
}
